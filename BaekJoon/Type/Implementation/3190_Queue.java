// https://www.acmicpc.net/problem/3190
// 뱀
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y]=1;
		}
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer,String> turn = new HashMap<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			turn.put(a, b);
		}
		
		int time = 0;
		Queue<int[]> body = new LinkedList<>();
		body.add(new int[] {1,1});
		map[1][1]=-1;
		Queue<int[]> head = new LinkedList<>();
		head.add(new int[] {1,1});
		
		// 반시계방향
		int[][] direction = {{0,1},{-1,0},{0,-1},{1,0}};
		int dIndex = 0;
		while(true){
			int[] now = head.poll();
			
			// 방향전환 인덱스
			if(turn.get(time)!=null){
				String d = turn.get(time);
				if(d.equals("L")){
					dIndex++;
				}else{
					dIndex--;
				}
				if(dIndex>3)dIndex=0;
				if(dIndex<0)dIndex=3;
			}
			
			// 다음 방향 좌표
			int[] next = {now[0]+direction[dIndex][0],now[1]+direction[dIndex][1]};
			time++;
			// System.out.println(next[0]+" "+next[1]);
			// 다음 방향 몸통 or 벽
			if(next[0]<1 || next[0]>N || next[1]<1 || next[1]>N || map[next[0]][next[1]]==-1){
				break;
			}else{
				//사과
				if(map[next[0]][next[1]]==0){
					int[] zero = body.poll();
					map[zero[0]][zero[1]]=0;
				}
				map[next[0]][next[1]]=-1;
				body.add(new int[] {next[0],next[1]});
				head.add(new int[] {next[0],next[1]});
			}
		}
		
		System.out.println(time);
		
		br.close();
		System.exit(0);
	}
	
}

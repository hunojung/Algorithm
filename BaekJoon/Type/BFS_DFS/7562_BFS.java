// https://www.acmicpc.net/problem/7562
// 나이트의 이동

// 분류
// 그래프 이론
// 그래프 탐색
// 너비 우선 탐색
import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[] dx = {2,1,-1,-2,-2,-1,1,2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        
        while(testcase-->0){
	        // 입력
	        N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
	        sb.append(bfs(x1,y1,x2,y2)+"\n");
	        
        }
        System.out.println(sb);
        br.close();
		System.exit(0);
	}
	static int bfs(int x1,int y1,int x2 ,int y2){
		int answer = 0;
		boolean[][] visit = new boolean[N][N];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x1,y1,0});
		visit[x1][y1]=true;
		while(!q.isEmpty()){
			
			int[] now = q.poll();
			
			if(now[0]==x2 && now[1]==y2){
				answer = now[2];
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int x = now[0]+dx[i];
				int y = now[1]+dy[i];
				
				if(x>-1 && x<N && y>-1 && y<N && !visit[x][y]){
					visit[x][y]=true;
					q.add(new int[] {x,y,now[2]+1});
				}
			}
		}
		return answer;
	}
}

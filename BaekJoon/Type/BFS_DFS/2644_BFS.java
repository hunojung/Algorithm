// https://www.acmicpc.net/problem/2644
// 촌수 계산
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b]=1;
			map[b][a]=1;
		}
		
		int answer = -1;
		boolean[] visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		q.add(0);
		visit[start]=true;
		while(!q.isEmpty()){
			int next = q.poll();
			int count = q.poll();
			
			if(next==end){
				answer =  count;
				break;
			}
			for (int i = 1; i < N+1; i++) {
				if(!visit[i]&& map[next][i]==1){
					q.add(i);
					q.add(count+1);
					visit[i]=true;
				}
			}
		}
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}

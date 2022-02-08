// https://www.acmicpc.net/problem/2638
// 치즈
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map,air;
	static int oneCount;
	static int[] dh = {0,1,0,-1},dw = {1,0,-1,0};
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		oneCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)oneCount++;
			}
		}
		while(oneCount>0){
			// 외곽 공기 칸 -1로 변환
			//System.out.println("oneCount : "+oneCount);
			answer++;
			bfs(N,M);
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if(air[i][j]>1){
						map[i][j]=-1;
						oneCount--;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
	
	static void bfs(int N,int M){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0});
		boolean[][] visit = new boolean[N][M];
		visit[0][0]=true;
		air = new int[N][M];
		
		while(!q.isEmpty()){
			int[] next = q.poll();
			for (int i = 0; i < 4; i++) {
				int h = next[0]+dh[i];
				int w = next[1]+dw[i];
				if(h>-1 && h<N && w>-1 && w<M && !visit[h][w]){
					if(map[h][w]==0 || map[h][w]==-1){
						map[h][w]=-1;
						q.add(new int[] {h,w});
						visit[h][w]=true;
					}else{
						air[h][w]++;
					}
				}
			}
		}
	}
}

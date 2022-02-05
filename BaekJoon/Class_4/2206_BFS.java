// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기
import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int[] dh={0,1,0,-1};
	static int[] dw={1,0,-1,0};
	static boolean[][][] visit;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(s.charAt(j)+"");
			}
		}
		
		bfs();
		
		if(min==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(min);
		
		br.close();
		System.exit(0);
	}
	
	static void bfs(){
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,1,0));
		visit[0][0][0]=true;
		while(!q.isEmpty()){
			
			Point next = q.poll();
			//System.out.println(next.h+" "+next.w);
			if(next.h==N-1 && next.w==M-1){
				min=next.length;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int n_h = next.h+dh[i];
				int n_w = next.w+dw[i];
				
				// map 범위
				if(n_h>-1 && n_h<N && n_w>-1 && n_w<M){
					
					if(next.wall==1){
						if(visit[n_h][n_w][1] || map[n_h][n_w]==1)
							continue;
						
						visit[n_h][n_w][1]=true;
						q.add(new Point(n_h,n_w,next.length+1,1));
					}else{
						if(visit[n_h][n_w][0])
							continue;
						
						visit[n_h][n_w][map[n_h][n_w]]=true;
						q.add(new Point(n_h,n_w,next.length+1,map[n_h][n_w]));
					}
				}
			}
		}
	}
	
	static class Point{
		int h;
		int w;
		int length;
		int wall;
		public Point(int h, int w, int length,int wall) {
			this.h = h;
			this.w = w;
			this.length = length;
			this.wall = wall;
		}
	}
}

// https://www.acmicpc.net/problem/1261
// 알고스팟

// 분류
// 그래프 이론
// 다익스트라
// 0-1 너비 우선 탐색
import java.io.*;
import java.util.*;

public class Main{
	static int W,H;
	static int[][] map;
	static int[][] wall;
	static int[] dh = {1,0,-1,0};
	static int[] dw = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][W+1];
		wall = new int[H+1][W+1];
		for (int i = 1; i < H+1; i++) {
			String s = br.readLine();
			for (int j = 1; j < W+1; j++) {
				map[i][j]=Integer.parseInt(s.charAt(j-1)+"");
				wall[i][j]=Integer.MAX_VALUE;
			}
		}
		bfs();
		
		System.out.println(wall[H][W]);
		br.close();
		System.exit(0);
	}
	
	static void bfs(){
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(1);
		wall[1][1]=map[1][1];
		
		while(!q.isEmpty()){
			int h = q.poll();
			int w = q.poll();
			//System.out.println(h+" "+w+" "+map[h][w]);
			for (int i = 0; i < 4; i++) {
				int newh = h+dh[i];
				int neww = w+dw[i];
				
				// 값이 작이질 수 있으면 전진
				if(newh > 0 && newh < H+1 && neww>0 && neww<W+1 && wall[newh][neww]>wall[h][w]+map[newh][neww]){
					q.add(newh);
					q.add(neww);
					wall[newh][neww]=wall[h][w]+map[newh][neww];
				}
			}
		}
	}
}

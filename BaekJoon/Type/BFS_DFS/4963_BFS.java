// https://www.acmicpc.net/problem/4963
// 섬의 개수

// 분류
// 그래프 이론
// 그래프 탐색
// 너비 우선 탐색
// 깊이 우선 탐색
import java.io.*;
import java.util.*;

public class Main{
	static int W,H;
	static int[][] map;
	static int[] dx = {-1,0,1,0,-1,1,1,-1};
	static int[] dy = {0,-1,0,1,1,1,-1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while((s = br.readLine())!=null && !s.equals("0 0")){
			StringTokenizer st = new StringTokenizer(s);
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j]==1){
						answer++;
						bfs(i,j);
					}
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void bfs(int h, int w){
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {h,w});
		
		while(!q.isEmpty()){
			int[] next = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int x = next[0]+dx[i];
				int y = next[1]+dy[i];
				if(x>-1 && x<H && y>-1 && y<W && map[x][y]==1){
					map[x][y]=0;
					q.add(new int[] {x,y});
				}
			}
		}
	}
}

// https://www.acmicpc.net/problem/2234
// 성곽

// 분류
// 그래프 이론
// 그래프 탐색
// 너비 우선 탐색
// 비트마스킹
import java.io.*;
import java.util.*;

public class Main{
	static int[][] areaNum;
	static int[][] area;
	static int[][] bit;
	static int H,W, maxArea=0;
	static int[] dx = {1,0,-1,0}; // 남,동,북,서
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		areaNum = new int[H][W];
		area = new int[H][W];
		bit = new int[H][W];
		
		// 1,2,4,8, 서,북,동,남
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				bit[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(areaNum[i][j]==0){
					count++;
					dfs(i,j,count);
				}
			}
		}
		
		sb.append(count).append("\n").append(maxArea).append("\n");
		int maxAddArea = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				
				for (int k = 0; k < 4; k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					
					if(x>-1 && x<H && y>-1 && y<W){
						if(areaNum[i][j]!=areaNum[x][y]){
							maxAddArea = Math.max(maxAddArea, area[i][j]+area[x][y]);
							//System.out.println(i+" "+j+" / "+x+" "+y+" / "+maxAddArea);
						}
					}
				}
			}
		}
		
		sb.append(maxAddArea).append("\n");
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	static void dfs(int h, int w, int number){
		// 지역 구역 번호
		areaNum[h][w]=number;
		
		Queue<int[]> q = new LinkedList<>();
		int addArea = 0;
		q.add(new int[] {h,w});
		
		while(!q.isEmpty()){
			int[] next = q.poll();
			int b = bit[next[0]][next[1]];
			addArea++;
			//System.out.println(next[0]+" "+next[1]);
			// bit 방향 
			int n = 8;
			for (int i = 0; i < 4; i++) {
				int x = next[0]+dx[i];
				int y = next[1]+dy[i];
				// 벽이 있는곳
				if(b>=n){
					b-=n;
				// 벽이 없는곳
				}else if(areaNum[x][y]==0){
					q.add(new int[] {x,y});
					// 지역 구역 번호
					areaNum[x][y]=number;
				}
				n/=2;
			}
		}
		
		// 지역번호 매겨진 곳 넓이 입력
		if(addArea>maxArea)maxArea=addArea;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(areaNum[i][j]==number){
					area[i][j]=addArea;
				}
			}
		}
	}
}

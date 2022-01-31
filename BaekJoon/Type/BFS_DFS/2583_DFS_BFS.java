// https://www.acmicpc.net/problem/2583
// 영역 구하기

// 분류
// 그래프 이론
// 그래프 탐색
// 너비 우선 탐색
// 깊이 우선 탐색
// DFS , BFS
import java.io.*;
import java.util.*;

public class Main{
	
	static int[][] map;
	static int[] dh = {1,0,-1,0};
	static int[] dw = {0,-1,0,1};
	static int H,W,K;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        
        for (int i = 0; i < K; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					map[j][k]=1;
				}
			}
		}
        int answer = 0;
        List<Integer> area = new ArrayList<>();
        for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]==0){
					area.add(bfs(i,j,1));
					answer++;
				}
			}
		}
        sb.append(answer+"\n");
        Collections.sort(area);
        for (int i = 0; i < area.size(); i++) {
			sb.append(area.get(i)+" ");
		}
        System.out.println(sb);
        
        br.close();
		System.exit(0);
	}
	
	static int bfs(int h, int w, int count){
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {h,w});
		map[h][w]=1;
		
		while(!q.isEmpty()){
			int[] next = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = next[0]+dh[i];
				int y = next[1]+dw[i];
				if(x>-1 && x<H && y>-1 && y<W && map[x][y]==0){
					map[x][y]=1;
					count++;
					q.add(new int[] {x,y});
				}
			}
		}
		return count;
	}
	
	static int dfs(int h, int w, int count){
		map[h][w]=1;
		
		for (int i = 0; i < 4; i++) {
			int x = h+dh[i];
			int y = w+dw[i];
			if(x>-1 && x<H && y>-1 && y<W && map[x][y]==0){
				count=dfs(x,y,count+1);
			}
		}
		return count;
	}
}

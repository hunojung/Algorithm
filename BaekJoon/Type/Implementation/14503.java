// https://www.acmicpc.net/problem/14503
// 로봇 청소기
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 1;
		int[] dx = {0,-1,0,1};
		int[] dy = {-1,0,1,0};
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 0,1,2,3 - 북 동 남 서
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		// 구현
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c,d});
		visit[r][c]=true;
		
		while(!q.isEmpty()){
			int[] next = q.poll();
			int direction = next[2];
			//System.out.println(next[0]+" "+next[1]+" "+next[2]);
			for (int i = 0; i < 4; i++) {
				// 현 위치에서 direction 방향에서 왼쪽
				int x = next[0]+dx[direction];
				int y = next[1]+dy[direction];
				direction--;
				if(direction<0)direction=3;
				
				// 왼쪽이 비었다 4방향 
				if(x>-1 && x<N && y>-1 && y<M && !visit[x][y] && map[x][y]==0){
					q.add(new int[] {x,y,direction});
					answer++;
					visit[x][y]=true;
					break;
				}
				
				// 4방향 모두 검토 후
				if(i==3){
					x =next[0]+(next[0]-x);
					y =next[1]+(next[1]-y);
					if(x>-1 && x<N && y>-1 && y<M && map[x][y]==0){
						q.add(new int[] {x,y,direction});
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}

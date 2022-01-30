// https://www.acmicpc.net/problem/2468
// 안전 영역

// 분류
// 그래프 이론
// 브루트포스 알고리즘
// 그래프 탐색
// 너비 우선 탐색
// 깊이 우선 탐색
import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				set.add(map[i][j]);
			}
		}
		
		int answer = 0;
		for (Integer h : set) {
			answer = Math.max(answer, height(h));
		}
		
		System.out.println(answer);

		br.close();
		System.exit(0);
	}
	
	static int height(int h){
		visit = new boolean[N][N];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j]>=h){
					answer++;
					bfs(i,j,h);
				}
			}
		}
		return answer;
	}
	
	static void bfs(int h, int w,int height){
		Queue<int[]> q = new LinkedList<>();
		
		visit[h][w]=true;
		q.add(new int[] {h,w});

		while(!q.isEmpty()){
			int[] next = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = next[0]+dx[i];
				int y = next[1]+dy[i];
				if(x>-1 && x<N && y>-1 && y<N && map[x][y]>=height && !visit[x][y]){
					visit[x][y]=true;
					q.add(new int[] {x,y});
				}
			}
		}
	}
}

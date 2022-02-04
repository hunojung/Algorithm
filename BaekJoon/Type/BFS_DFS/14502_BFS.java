// https://www.acmicpc.net/problem/14502
// 연구소
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int N,M,not_safe,answer=0,safe=0;
	static List<Point> list;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0){
					safe++;
					list.add(new Point(i,j));
				}
			}
		}
		dfs(0,0);
		
		System.out.println(answer);
		
		br.close();
		System.exit(0);
	}
	
	static void bfs(int x,int y){
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visit[x][y]=true;
		
		while(!q.isEmpty()){
			Point next = q.poll();
			for (int i = 0; i < 4; i++) {
				x = next.x+dx[i];
				y = next.y+dy[i];
				if(x>-1 && x<N && y>-1 && y<M && !visit[x][y] && map[x][y]==0){
					q.add(new Point(x,y));
					not_safe++;
					visit[x][y]=true;
				}
			}
		}
	}
	
	static void dfs(int index,int count){

		if(count==3){
			visit = new boolean[N][M];
			not_safe = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==2){
						bfs(i,j);
					}
				}
			}

			answer = Math.max(answer, safe-(not_safe+3));
			return;
		}
        
        if(index==safe){
			return;
		}
		
		Point next = list.get(index);
		map[next.x][next.y]=1;
		dfs(index+1,count+1);
		map[next.x][next.y]=0;
		
		dfs(index+1,count);
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

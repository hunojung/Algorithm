// 유기농 배추
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] cabbage;
	static int[] mx = {-1,1,0,0};
	static int[] my = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력 
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			cabbage = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				cabbage[x][y] = 1;
			}
			
			int count =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(cabbage[i][j]==1){
						bfs(N,M,i,j);
						count++;
					}
				}
				
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void bfs(int N,int M,int x,int y){
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		while(!q.isEmpty()){
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				x = p.x+mx[i];
				y = p.y+my[i];
				if(x>=0 && x<N && y>=0 && y<M && cabbage[x][y]==1){
					q.add(new Point(x,y));
					cabbage[x][y]=0;
				}
			}
		}
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

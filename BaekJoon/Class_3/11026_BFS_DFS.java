// 적록 색약
// 11026 BFS
// DFS 는 Queue => Stack / poll() => pop()
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		char[][] painting = new char[N][N];
		char[][] paintingRGB = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				painting[i][j]=s.charAt(j);
				if(s.charAt(j)=='R'){

					paintingRGB[i][j]='G';
				}else{
					paintingRGB[i][j]=s.charAt(j);
					
				}
			}
		}

		
		System.out.println(bfs(painting,N)+" "+bfs(paintingRGB,N));

		br.close();
		System.exit(0);
	}

	public static int bfs(char[][] painting, int N){
		int count=0 ;
		int[][] ok = new int[N][N];
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if(ok[i][j]==0){
					
					q.add(new Point(i,j,painting[i][j]));
					while(!q.isEmpty()){
						Point P = q.poll();
						
						if(P.x>0 && P.RGB == painting[P.x-1][P.y] && ok[P.x-1][P.y]==0){
							q.add(new Point(P.x-1,P.y,P.RGB));
							ok[P.x-1][P.y]=1;
						}
						if(P.x+1<N && P.RGB == painting[P.x+1][P.y] && ok[P.x+1][P.y]==0){
							q.add(new Point(P.x+1,P.y,P.RGB));
							ok[P.x+1][P.y]=1;
						}
						if(P.y>0 && P.RGB == painting[P.x][P.y-1] && ok[P.x][P.y-1]==0){
							q.add(new Point(P.x,P.y-1,P.RGB));
							ok[P.x][P.y-1]=1;
						}
						if(P.y+1<N && P.RGB == painting[P.x][P.y+1] && ok[P.x][P.y+1]==0){
							q.add(new Point(P.x,P.y+1,P.RGB));
							ok[P.x][P.y+1]=1;
						}
					}
					count++;
				}
			}
		}
		return count;
	}
	
	static class Point{
		
		int x;
		int y;
		char RGB;
		
		public Point(int x, int y, char RGB) {
			this.x = x;
			this.y = y;
			this.RGB = RGB;
		}
	}
}
// 11026 END

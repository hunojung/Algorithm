// 미로 탐색
// 2178
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] maze;
	static int[][] ok;
	static int min = -1;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		ok = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j]=line.charAt(j)-'0';
			}
		}
		//System.out.println("ok");
		
		
		System.out.println(bfs(N,M));
		
		br.close();
		System.exit(0);
	}
	
	public static int bfs(int N, int M){
		int count = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		q.add(count);
		ok[0][0]=1;
		
		while(!q.isEmpty()){
			int x = q.poll();
			int y = q.poll();
			count = q.poll();
			//System.out.println(x+" "+y+" "+count);
			if(x==N-1 && y==M-1){
				break;
			}
			count++;
			
			if(x>0 && maze[x-1][y]==1 && ok[x-1][y]==0){
				q.add(x-1);
				q.add(y);
				q.add(count);
				ok[x-1][y]=1;
			}
			if(x+1<N && maze[x+1][y]==1 && ok[x+1][y]==0){
				q.add(x+1);
				q.add(y);
				q.add(count);
				ok[x+1][y]=1;
			}
			if(y>0 && maze[x][y-1]==1 && ok[x][y-1]==0){
				q.add(x);
				q.add(y-1);
				q.add(count);
				ok[x][y-1]=1;
			}
			if(y+1<M && maze[x][y+1]==1 && ok[x][y+1]==0){
				q.add(x);
				q.add(y+1);
				q.add(count);
				ok[x][y+1]=1;
			}
		}
		
		return count;
	}
}
// 2178 END

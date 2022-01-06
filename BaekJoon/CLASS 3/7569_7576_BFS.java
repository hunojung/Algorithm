// 토마토 
// 7569 3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] tomato;
	static int M;
	static int N;
	static int H;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		tomato = new int[M][N][H];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < M; j2++) {
					tomato[j2][j][i]=Integer.parseInt(st.nextToken());
				}
			}
		}
		br.close();

		// 3 3 1
		// 1 0 0
		// 0 0 0
		// 0 0 1
		// 위의 경우 2가 나오려면 일단 '1'인 위치를 모두 큐에 담고
		// 시작해야한다
		// 1 나오자마자 bfs 시작하면 안된다.
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(tomato[j2][j][i]==1){
						//System.out.println(j+" "+j2+" "+i);
						q.add(j2);
						q.add(j);
						q.add(i);
					}
				}
			}
		}
		
		bfs(q);
		
		int maxC = 0; // max count 값
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(maxC < tomato[j2][j][i]) maxC = tomato[j2][j][i];
					
					if(tomato[j2][j][i]==0){
						System.out.println(-1);
						System.exit(0);
						
					}
				}
			}
		}
		
		System.out.println(maxC-1);
		
		br.close();
		System.exit(0);
	}
	
	public static void bfs(Queue<Integer> q){
		
		while(!q.isEmpty()){
			int x = q.poll();
			int y = q.poll();
			int z = q.poll();
			
			if(x>0 && tomato[x-1][y][z] == 0 ){
				q.add(x-1);
				q.add(y);
				q.add(z);
				tomato[x-1][y][z] = tomato[x][y][z]+1;
			}
			
			if(x+1<M && tomato[x+1][y][z] == 0 ){
				q.add(x+1);
				q.add(y);
				q.add(z);
				tomato[x+1][y][z] = tomato[x][y][z]+1;
			}
			if(y>0 && tomato[x][y-1][z] == 0){
				q.add(x);
				q.add(y-1);
				q.add(z);
				tomato[x][y-1][z] = tomato[x][y][z]+1;
			}
			if(y+1<N && tomato[x][y+1][z] == 0){
				q.add(x);
				q.add(y+1);
				q.add(z);
				tomato[x][y+1][z] = tomato[x][y][z]+1;
			}
			if(z>0 && tomato[x][y][z-1] == 0){
				q.add(x);
				q.add(y);
				q.add(z-1);
				tomato[x][y][z-1] = tomato[x][y][z]+1;
			}
			if(z+1<H && tomato[x][y][z+1] == 0){
				q.add(x);
				q.add(y);
				q.add(z+1);
				tomato[x][y][z+1] = tomato[x][y][z]+1;
			}
		}
	}
}
// 7569 END

//7576 2차원
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] tomato;
	static int M;
	static int N;
	static int H;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		tomato = new int[M][N];

		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int j2 = 0; j2 < M; j2++) {
				tomato[j2][j]=Integer.parseInt(st.nextToken());
			}
		}
	
		br.close();

		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < M; j2++) {
				if(tomato[j2][j]==1){
					//System.out.println(j+" "+j2+" "+i);
					q.add(j2);
					q.add(j);
				}
			}
		}
		
		bfs(q);
		
		int maxC = 0; // max count 값
		for (int j = 0; j < N; j++) {
			for (int j2 = 0; j2 < M; j2++) {
				if(maxC < tomato[j2][j]) maxC = tomato[j2][j];
				
				if(tomato[j2][j]==0){
					System.out.println(-1);
					System.exit(0);
					
				}
			}
		}
		
		System.out.println(maxC-1);
		
		br.close();
		System.exit(0);
	}
	
	public static void bfs(Queue<Integer> q){
		
		while(!q.isEmpty()){
			int x = q.poll();
			int y = q.poll();
			
			if(x>0 && tomato[x-1][y] == 0 ){
				q.add(x-1);
				q.add(y);
				tomato[x-1][y] = tomato[x][y]+1;
			}
			
			if(x+1<M && tomato[x+1][y] == 0 ){
				q.add(x+1);
				q.add(y);
				tomato[x+1][y] = tomato[x][y]+1;
			}
			if(y>0 && tomato[x][y-1] == 0){
				q.add(x);
				q.add(y-1);
				tomato[x][y-1] = tomato[x][y]+1;
			}
			if(y+1<N && tomato[x][y+1] == 0){
				q.add(x);
				q.add(y+1);
				tomato[x][y+1] = tomato[x][y]+1;
			}
		}
	}
}
// 7576 END

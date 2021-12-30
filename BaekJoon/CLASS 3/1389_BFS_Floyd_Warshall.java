// 케빈 베이컨의 6단계 법칙
// 플로이드 와샬
/*
입력 : 
5 5
1 3
1 4
4 5
4 3
3 2

초기 세팅 :
0 987654321 1 1 987654321 
987654321 0 1 987654321 987654321 
1 1 0 1 987654321 
1 987654321 1 0 1 
987654321 987654321 987654321 1 0 

플로이드 와샬 결과 
0 2 1 1 2 
2 0 1 2 3 
1 1 0 1 2 
1 2 1 0 1 
2 3 2 1 0
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] friends = new int[N+1][N+1]; // 친구 연결을 확인
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if( i != j ) friends[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a][b]=friends[b][a]=1;
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if(friends[i][j] > friends[i][k]+friends[k][j]){
						friends[i][j] = friends[i][k]+friends[k][j];
					}
				}
			}
		}

		int res = INF;
		int idx = -1;
		
		for (int i = 1; i < N+1; i++) {
			int total = 0;
			
			for (int j = 1; j < N+1; j++) {
				total += friends[i][j];
			}
			
			if (total < res){
				res = total;
				idx = i;
			}
		}
		
		System.out.println(idx);
		br.close();
		System.exit(0);
	}	
}
// 플로이드 와샬 END



// BFS
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] friends = new int[N+1][N+1]; // 친구 연결을 확인
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a][b]=1;
			friends[b][a]=1;
		}
		
		int who = bfs(friends,N, N-1);
		
		System.out.println(who);
		
		System.exit(0);
	}	
	
	public static int bfs(int[][] friends, int N, int O){
		int size = friends.length;
		int[] testcase ={N>2?bfs(friends,N-1,N-2):O,N}; // 작은 값인 O를 먼저 돌려봄
		
		int count=0;
		int who=0;
		for (int i = 0; i < 2; i++) {				
			
			Queue<Integer> friend_order = new LinkedList<>(); // BFS 친구들 저장
			friend_order.add(testcase[i]);
			
			int[] confirmed = new int[size]; // 방문 기록
			while(!friend_order.isEmpty()){
				int next = friend_order.poll();
				for (int j = 1; j < size; j++) {
					
					if(friends[next][j]==1 && confirmed[j]==0){
						friend_order.add(j);
						confirmed[j]=confirmed[next]+1;
					}
				}
			}
			
			int sum = IntStream.of(confirmed).sum();
			if( count == 0 || count > sum){
				count = sum;
				who=testcase[i];
			}
		}
		return who;
	}
}
// BFS END

// 연결 요소의 개수
// 11724
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 방향 없는 그래프
이 말은 양방향 그래프라는 말임. 서로서로 이동가능함.

u→v

v→u

2. 간선 정보가 없는 노드도 연결 요소로 포함

(1 ≤ u, v ≤ N, u ≠ v) 라는 조건에 의해 무조건 1부터 N까지 순서대로 노드 존재함.

※ 입력으로 주어진 간선 정보가 없다고 해당 노드가 없는게 아님.

N = 3이면 : 1,2,3

N = 6이면 : 1,2,3,4,5,6



예시 테스트 케이스

6 2
3 4
4 2

2,3,4가 연결된 상태라서 정답이 1개가 아님

1,5,6도 단일 노드로 존재하여 답이 4가됨.
 */
public class Main {
	static int[][] line;
	static boolean[] ok;
	static int N,M;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		line = new int[N+1][N+1];
		ok =new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			line[s][e]=1;
			line[e][s]=1;
		}
		
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if(!ok[i]){
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
	
	static void dfs(int i){
		ok[i]=true;
		
		for (int k = 1; k < N+1; k++) {
			if(!ok[k] && line[i][k]==1){
				dfs(k);
			}
		}
	}
  
  static void bfs(int i){
		ok[i]=true;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		
		while(!q.isEmpty()){
			int next = q.poll();
			for (int k = 1; k < N+1; k++) {
				if(!ok[k] && line[next][k]==1){
					ok[k]=true;
					q.add(k);
				}
			}		
		}
	}
}
// 11724 END

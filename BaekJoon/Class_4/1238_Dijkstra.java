[https://www.acmicpc.net/submit/1238/37897885](https://www.acmicpc.net/submit/1238/37897885)
// 파티

// 분류
// 그래프 이론
// 다익스트라
import java.io.*;
import java.util.*;

public class Main{
	static int[] students;
	static List<Node>[] arr;
	static int N,M,X;
	static int max = 0;
	
	static int[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		students = new int[N+1];
		Arrays.fill(students,Integer.MAX_VALUE);
		arr = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			arr[x].add(new Node(y,n));
		}
		
		for (int i = 1; i < N+1; i++) {
			int sum = 0;
			
			sum+=dijkstra(i,X);
			sum+=dijkstra(X,i);
			
			max = Math.max(max, sum);
			//max = Math.max(max, dfs(i,X,0,Integer.MAX_VALUE));		
		}
		
		System.out.println(max);
		
		br.close();
		System.exit(0);
	}
	
	static int dijkstra (int path,int goal){
		
		boolean[] visit = new boolean[N+1];
		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		// 시작할 노드를 최솟값으로 설정하고 처음에 걸리게함
		int start = path;
		cost[start]=0;
		
		// 방문 체크하면서 N번하면 모든 노드 들리게 됨
		for (int i = 1; i < N+1; i++) {
			
			// 방문하지 않은 것 중 최솟값인 노드
			int nextNodeCost = Integer.MAX_VALUE;
			for (int j = 1; j < N+1; j++) {
				if(!visit[j] && cost[j]<nextNodeCost){
					nextNodeCost = cost[j];
					start = j;
				}
			}
			
			// 노드 골랐으면 체크
			visit[start]=true;
			
			for (int j = 0; j < arr[start].size(); j++) {
				Node node = arr[start].get(j);
				
				if(cost[node.n]>cost[start]+node.cost){
					cost[node.n]=cost[start]+node.cost;
				}
			}
		}
		return cost[goal];
	}
	
	static class Node{
		int n;
		int cost;
		public Node(int n, int cost) {
			super();
			this.n = n;
			this.cost = cost;
		}
	}
}

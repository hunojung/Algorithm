// https://www.acmicpc.net/problem/1504
// 특별한 최단 경로
import java.util.*;
import java.io.*;

public class Main {
	static List<Node>[] list;
	static int N,E;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i]=new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		long v1v2 = dijkstra(v1,v2);

		long ans1 = dijkstra(1,v1)+v1v2+dijkstra(v2,N);
		long ans2 = dijkstra(1,v2)+v1v2+dijkstra(v1,N);
		
		long ans = (ans1>=INF && ans2>=INF)?-1:Math.min(ans1, ans2);

		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
	
	static long dijkstra(int start, int end) {
		boolean[] visited = new boolean[N+1];
		int[] cost = new int[N+1];
		Arrays.fill(cost, INF);
		cost[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,cost[start]));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(!visited[now.n]) {
				
				visited[now.n]= true;
				for (int i = 0; i < list[now.n].size();i++) {
					Node next = list[now.n].get(i);
					
					if(cost[next.n]>cost[now.n]+next.cost) {
						cost[next.n]= cost[now.n]+next.cost;
						pq.add(new Node(next.n,cost[next.n]));
					}
				}
			}
		}
		
		return cost[end];
	}
	
	static class Node implements Comparable<Node>{
		int n;
		int cost;
		public Node(int n, int cost) {
			super();
			this.n = n;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
}

// https://www.acmicpc.net/problem/1753
// 최단경로

// 다익스트라, 우선순위큐 두가지로 풀었다
// 우선순위큐는 CompareTo cost 기준으로 해주어야한다.

// 분류
// 그래프 이론
// 다익스트라

// 다익스트라 풀이
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine())-1;
		
		List<Node>[] arr = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());

			arr[a].add(new Node(b,c));
		}
		
		int[] cost = new int[V];
		boolean[] visit = new boolean[V];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start]=0;
		
		for(int i = 0 ; i < V;i++){
			
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < V; j++) {
				if( !visit[j] && min>cost[j]){
					min=cost[j];
					start=j;
				}
			}
			
			visit[start]=true;
			
			for (Node next : arr[start]) {
				
				if(!visit[next.n] && cost[next.n]>cost[start]+next.cost){
					cost[next.n]=cost[start]+next.cost;
				}
			}
		}
        
		for (int i = 0; i < V; i++) {
			int next = cost[i];
			if(next==Integer.MAX_VALUE){
				sb.append("INF").append("\n");
			}else{
				sb.append(next).append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
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

// 우선순위 큐
import java.io.*;
import java.util.*;

public class Main{
	static List<Node>[] arr;
	static int V,E;
	static Integer[] cost;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[V+1];
		cost = new Integer[V+1];
		visit = new boolean[V+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		for (int i = 0; i < V+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr[a].add(new Node(b,c));
			
		}
		
		cost[start]=0;
		dijkstra(start);
		
		for (int i = 1; i < V+1; i++) {
			int next = cost[i];
			if(next==Integer.MAX_VALUE){
				sb.append("INF").append("\n");
			}else{
				sb.append(next).append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void dijkstra(int start){
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0));
		
		while(!q.isEmpty()){
			Node now = q.poll();
			for (Node next : arr[now.n]) {
				
				if(cost[next.n]>now.cost+next.cost){
					cost[next.n]=now.cost+next.cost;
					q.add(new Node(next.n,cost[next.n]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int n;
		int cost;
		public Node(int n, int cost) {
			super();
			this.n = n;
			this.cost = cost;
		}
		
		public int compareTo(Node o){
			return this.cost - o.cost;
		}
	}
}

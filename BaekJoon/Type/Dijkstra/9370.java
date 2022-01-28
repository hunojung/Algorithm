// https://www.acmicpc.net/problem/9370
// 미확인 도착지

// 분류
// 그래프 이론
// 다익스트라
import java.io.*;
import java.util.*;

public class Main{
	static int n,m,t,s,g,h;
	static int[] x;
	static List<Node>[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// n - 교차로, m - 도로, t 목적지 후보 갯수
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			x = new int[t];
			list = new ArrayList[n+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n+1; i++) {
				list[i]= new ArrayList<>();
			}
			// s출발 g,h 사이 거리 지나감
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// a-b 양방향 d거리 도리
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b,d));
				list[b].add(new Node(a,d));
			}
			
			// 예상 목적지
			for (int i = 0; i < t; i++) {
				x[i]=Integer.parseInt(br.readLine());
			}
			Arrays.sort(x);
			// 출발점에서 g,h를 거쳐 목적지 까지 거리
			for (int i = 0; i < t; i++) {
				int ghcost = dijkstra(h,g);
				int cost1 = dijkstra(s,g)+ghcost+dijkstra(h,x[i]);
				int cost2 = dijkstra(s,h)+ghcost+dijkstra(g,x[i]);
				int cost3 = dijkstra(s,x[i]);
				//System.out.println(s+" "+x[i]+" "+cost1+" "+cost2+" "+cost3);
				if(Math.min(cost1, cost2)==cost3){
					sb.append(x[i]+" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static int dijkstra(int start, int destiny){
		int[] cost = new int[n+1];
		boolean[] visit = new boolean[n+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		cost[start]=0;
		
		for (int i = 0; i < n; i++) {
		
			int min=Integer.MAX_VALUE;
			for (int j = 1; j < n+1; j++) {
				if(!visit[j] && min>cost[j]){
					min=cost[j];
					start=j;
				}
			}
			visit[start]=true;
			
			for (int j = 0; j < list[start].size(); j++) {
				Node next = list[start].get(j);
				
				if(cost[next.n]>cost[start]+next.cost){
					cost[next.n]=cost[start]+next.cost;
				}
			}
		}
		return cost[destiny];
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

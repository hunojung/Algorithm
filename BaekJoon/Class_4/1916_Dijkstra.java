// https://www.acmicpc.net/problem/1916
// 최소비용 구하기

// 분류
// 그래프 이론
// 다익스트라
import java.io.*;
import java.util.*;

public class Main{
	static List<Node>[] list;
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i]=new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start,end));
		br.close();
		System.exit(0);
	}
	
	static int dijkstra(int start, int end){
		boolean[] visit = new boolean[N+1];
		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start]=0;
		
		for (int i = 0; i < N; i++) {
			
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < N+1; j++) {
				
				if(!visit[j] && cost[j]<min){
					min = cost[j];
					start = j;
				}
			}
				
			visit[start]=true;
			
			for (int k = 0; k < list[start].size(); k++) {
				Node next = list[start].get(k);
				
				if(cost[next.n]>cost[start]+next.cost){
					cost[next.n]=cost[start]+next.cost;
				}
			}
		}
	
		return cost[end];
	}
	
	static class Node{
		int n;
		int cost;
		public Node(int n,int cost){
			this.n=n;
			this.cost=cost;
		}
	}
}

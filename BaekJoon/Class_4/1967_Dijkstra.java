// https://www.acmicpc.net/problem/1967
// 트리의 지름

// 분류
// 그래프 이론
// 그래프 탐색
// 트리
// 깊이 우선 탐색
import java.io.*;
import java.util.*;

public class Main {
	static List<Node>[] list;
	static int N,answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<N-1;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		
		dijkstra(dijkstra(1));
		
		if(answer==Integer.MAX_VALUE)answer=0;
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
	
	static int dijkstra(int start){
		boolean[] visit = new boolean[N+1];
		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start]=0;
		
		for (int i = 0; i < N; i++) {
			
			int min = Integer.MAX_VALUE;
			for (int j = 1; j < N+1; j++) {
				if(!visit[j] && cost[j]<min){
					min = cost[j];
					start=j;
				}
			}
			
			visit[start]=true;
			
			for (int j = 0; j < list[start].size(); j++) {
				Node next = list[start].get(j);
				if(cost[next.n]>next.cost+cost[start]){
					cost[next.n]=next.cost+cost[start];
				}
			}
		}
		
		int next = 0;
		int max = 0;
		for (int i = 1; i < N+1; i++) {
			if(max<cost[i]){
				max=cost[i];
				next=i;
			}
		}
		answer = max;
		return next;
	}
	
	static class Node{
		int n;
		int cost;
		public Node(int n , int cost){
			this.n = n;
			this.cost = cost;
		}
	}
}

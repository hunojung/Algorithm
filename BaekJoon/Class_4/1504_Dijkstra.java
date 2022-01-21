// https://www.acmicpc.net/problem/1504
// 특별한 최단 경로

// 분류
// 그래프 이론
// 다익스트라

//반례 1 - 답 -1
/*
2 0
1 2
*/
		
//반례 2 - 답 8
/*
4 5
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
2 3
*/
import java.io.*;
import java.util.*;

public class Main{
	
	static List<Node>[] list;
	static int N,E;
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
		
		// v1, v2가 1또는 N 일수있다
		// v1 = 1 >> 1 - v2 - N
		// v2 = N >> 1 - v1 - N
		// v1=1 / v2=N >> 1 - N
		int ans = -1;
		
		int num1 = dijkstra(1,v1);
		int num2 = dijkstra(1,v2);
		int num3 = dijkstra(v1,v2);
		int num4 = dijkstra(v1,N);
		int num5 = dijkstra(v2,N);
		
		int ans1 = num1+num3+num5;
		int ans2 = num2+num3+num4;
		if(ans1 != 0 && ans2==0){
			ans = ans1;			
		}else if(ans1 == 0 && ans2!=0){
			ans = ans2;
		}else if(ans1*ans2!= 0){
			ans = Math.min(ans1, ans2);
		}
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
	
	// 시작, 끝 , 들리면안되는 두점
	static int dijkstra(int start, int end){
		
		boolean[] visit=new boolean[N+1];
		int[] cost = new int [N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		cost[start]=0;
		
		for (int i = 1; i < N+1; i++) {
			
			int min=Integer.MAX_VALUE;
			for (int j = 1; j < N+1; j++) {
				if(!visit[j] && min>cost[j]){
					min=cost[j];
					start = j;
				}
			}
			visit[start]=true;
			
			for (int j = 0; j < list[start].size(); j++) {
				Node next = list[start].get(j);
				if(!visit[next.n] && cost[next.n]>next.cost+cost[start]){
					cost[next.n]=next.cost+cost[start];
				}
			}
		}
		if(cost[end]<Integer.MAX_VALUE)return cost[end];
		else return 0;
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

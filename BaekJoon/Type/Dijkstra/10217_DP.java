// https://www.acmicpc.net/problem/10217 
// KCM Travel

// 분류
// 다이나믹 프로그래밍
// 그래프 이론
// 다익스트라
import java.io.*;
import java.util.*;

public class Main{
	static List<Node>[] list;
	static int N,M,K,answer;
	static int[] time;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
        int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	list = new ArrayList[N+1];
    		
    		dp = new int[N+1][M+1];
        	for (int i = 0; i < N+1; i++) {
				list[i]= new ArrayList<>();
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
        	
        	for (int i = 0; i < K; i++) {
        		st = new StringTokenizer(br.readLine());
        		int u = Integer.parseInt(st.nextToken());
        		int v = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		list[u].add(new Node(v,c,d));
			}

        	answer=Integer.MAX_VALUE;
    		dijkstra();
        	
        	if(answer==Integer.MAX_VALUE)sb.append("Poor KCM\n");
        	else sb.append(answer+"\n");
		}
        // 출력
        System.out.println(sb);
        br.close();
		System.exit(0);
	}
	
	static void dijkstra(){

		dp[1][0]=0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0,0));
		
		while(!pq.isEmpty()){
			Node now = pq.poll();
			
			// 최단 시간에 도착
			if(now.n==N){
				answer = Math.min(answer, now.time);
				break;
			}
			
			for(Node next : list[now.n]){
				int cost = now.cost+next.cost;
				if(cost > M)continue;
				
				int time = now.time+next.time;
				if(dp[next.n][cost]>time){
					dp[next.n][cost]=time;
					pq.add(new Node(next.n,cost,time));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int n;
		int cost;
		int time;
		
		public Node(int n, int cost, int time) {
			this.n = n;
			this.cost = cost;
			this.time = time;
		}
		
		@Override
		public int compareTo(Node o) {
			
			if(this.time==o.time)return this.cost-o.cost;
			return this.time-o.time;
		}
		
	}
}

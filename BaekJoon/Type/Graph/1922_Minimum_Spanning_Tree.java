// 네트워크 연결
// https://www.acmicpc.net/problem/1922
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Edge(a,b,c));
		}
		
		int cost = 0;
		int[] parents = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parents[i]=i;
		}
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int a = find(parents,now.a);
			int b = find(parents,now.b);
			if(a==b) continue;
			parents[b]=a;
			cost+=now.c;
		}
		
		System.out.println(cost);
		
		br.close();
		System.exit(0);
	}
	
	static int find(int[] parents,int n) {
		if(parents[n]==n)return n;
		return parents[n]=find(parents,parents[n]);
	}
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		public Edge(int a,int b,int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return c-o.c;
		}
	}
}

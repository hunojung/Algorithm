// https://www.acmicpc.net/problem/1197
// 최소 스패닝 트리
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] parent = new int[V+1];
		for(int i=1;i<V+1;i++)
			parent[i]=i;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Edge(a,b,c));
		}
		int len = 0;
		while(!pq.isEmpty()){
			Edge now = pq.poll();
			int a = find(parent,now.a);
			int b = find(parent,now.b);
			if(a==b) continue;
			
			parent[b]=a;
			len+=now.c;
		}
		System.out.println(len);
		br.close();
		System.exit(0);
	}
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Edge o) {
			return this.c-o.c;
		}
	}
	
	static int find(int[] parent,int n){
		if(parent[n]==n)return n;
		return parent[n]=find(parent,parent[n]);
	}
}

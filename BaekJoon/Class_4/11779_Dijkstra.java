// https://www.acmicpc.net/problem/11779
// 최소비용 구하기 2
import java.io.*;
import java.util.*;

public class Main {
	static List<Node>[] list;
	static int N,M;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		br.close();
		
		List<Integer> city = new ArrayList<>();
		city.add(start);
		
		dijkstra(start,end);
	}
	
	static void dijkstra(int start,int end){
		long[][] cost = new long[N+1][2];
		boolean[] visit = new boolean[N+1];
		cost[start][1]=1;
		int startIndex = start;
		for (int i = 0; i < N; i++) {
			
			long costMin = -1;
			for(int j=1;j<N+1;j++){
				if(!visit[j]&& cost[j][1]!=0 && (costMin==-1 || costMin>cost[j][1])){
					costMin=cost[j][1];
					start=j;
				}
			}
			
			visit[start]=true;
			
			for(int j=0;j<list[start].size();j++){
				Node next = list[start].get(j);
				
				if(!visit[next.n] && (cost[next.n][1]==0 || cost[next.n][1]>cost[start][1]+next.cost)){
					cost[next.n][1]=cost[start][1]+next.cost;
					cost[next.n][0]=start;
				}
			}
		}
		int index = end;
		Stack<Integer> stack = new Stack<>();
		while(index!=startIndex){
			stack.add(index);
			index = (int)cost[index][0];
		}
		stack.add(startIndex);
		
		StringBuilder sb = new StringBuilder();
		sb.append((cost[end][1]-1)+"\n"+stack.size()+"\n");
		while(!stack.isEmpty())
			sb.append(stack.pop()+" ");
		System.out.println(sb);
		System.exit(0);
	}
	
	static class Node{
		int n;
		long cost;
		public Node(int n, long cost) {
			this.n = n;
			this.cost = cost;
		}
	}
}

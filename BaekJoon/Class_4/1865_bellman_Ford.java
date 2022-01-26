// https://www.acmicpc.net/problem/1865
// 웜홀

// 분류
// 그래프 이론
// 벨만–포드
import java.io.*;
import java.util.*;

public class Main{
	static int N,M,W;
	static List<Node>[] list;
	static int[] cost;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				list[i]=new ArrayList<>();
			}
			
			// 값 입력
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				list[S].add(new Node(E,T));
				list[E].add(new Node(S,T));
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				list[S].add(new Node(E,-T));
			}
			
			String answer="NO";
			if(bellmanFord(1))answer="YES";
			
			sb.append(answer+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static boolean bellmanFord(int start){
		
        // 음수 사이클이 있으면 무조건 실행 되니까 초기화 상태로 둠
        cost = new int[N+1];
		
		//노드 갯수 만큼 실행
		for (int i = 0; i < N; i++) {
			boolean update = false;
			// N개의 노드에 대해 실행
			for (int j = 1; j < N+1; j++) {
				for (int k = 0; k < list[j].size(); k++) {
					Node next = list[j].get(k);
					
					if(cost[next.n]>cost[j]+next.cost){
						update =true;
						cost[next.n]=cost[j]+next.cost;
					}
				}
			}
			//N번 했을때 중간에 업데이트가 없다면 끝
			if(!update)return false;
		}
		return true;
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

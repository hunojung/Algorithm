// https://www.acmicpc.net/problem/1167
// 트리의 지름

// 진짜 나무라고 생각하고 모든 가지가 연결되어있는데
// 가장 먼 두 가지를 찾는 것
// 한번 가장 먼 가지 찾고 거기서 다시 먼데로 가면 무조건 젤먼거


// 분류
// 그래프 이론
// 그래프 탐색
// 트리
// 깊이 우선 탐색
import java.io.*;
import java.util.*;

public class Main{
	static List<Node>[] list;
	static int N;
	static boolean[] ok;
	
	static int max = 0;
	static int nodeNum = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();			
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 해당 정점에 연결된 선
			int len = (st.countTokens()/2)-1;
			int first = Integer.parseInt(st.nextToken())-1;
			for (int j = 0; j < len; j++) {
				int n = Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				// 경로별 지름
				list[first].add(new Node(n, cost));
			}
		}
		
		ok = new boolean[N];
		dfs(nodeNum,0);
		
		ok = new boolean[N];
		dfs(nodeNum,0);

		
		System.out.println(max);
		br.close();
		System.exit(0);
	}

	static void dfs(int node , int sum){
		ok[node]=true;
		// 가장 먼 노드 저장
		if(sum>max){
			max = sum;
			nodeNum = node; 
		}
		
		for (int i = 0; i < list[node].size(); i++) {
			Node next = list[node].get(i);
			if(ok[next.n])continue;
			dfs(next.n,sum+next.cost);
		}
	}
	
	static class Node{
		int n;
		int cost;
		
		public Node(int n,int cost) {
			this.n = n;
			this.cost = cost;
		}
	}
}

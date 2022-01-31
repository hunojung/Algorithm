// https://www.acmicpc.net/problem/11725
// 트리의 부모 찾기

// 분류
// 그래프 이론
// 그래프 탐색
// 트리
// 너비 우선 탐색
// 깊이 우선 탐색

// DFS_BFS
import java.io.*;
import java.util.*;

public class Main{
	static List<Integer>[] list;
	static int[] parents;
	static int N;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 입력
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        parents = new int[N+1];
        for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < N-1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
        dfs(0,1);
        //bfs();
        
        for (int i = 2; i < N+1; i++) {
			sb.append(parents[i]).append("\n");
		}
        System.out.println(sb);
        br.close();
		System.exit(0);
	}
	static void dfs(int before, int now){
		
		for(int i : list[now]){
			if(i!=before){
				parents[i]=now;
				dfs(now,i);
			}
		}
		
	}
	static void bfs(){
		boolean[] visit = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty()){
			
			int now = q.poll();
			visit[now]=true;
			
			for(int i : list[now]){
				
				if(!visit[i]){
					parents[i]=now;
					q.add(i);
				}
			}
		}
	}
}

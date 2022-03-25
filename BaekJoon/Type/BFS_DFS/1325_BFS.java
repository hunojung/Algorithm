// https://www.acmicpc.net/problem/1325
// 효율적인 해킹
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] map = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			map[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a].add(b);
		}
		
		int[] ans = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			boolean[] used = new boolean[N+1];
			bfs(map,ans,used,i);
		}
		
		StringBuilder sb = new StringBuilder();
		int max = 0;
		for (int i = 1; i < N+1; i++) {
			if(max<ans[i]) {
				sb = new StringBuilder();
				sb.append(i+" ");
				max = ans[i];
			}else if(max == ans[i]) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void bfs(List<Integer>[] map,int[] ans,boolean[] used ,int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		used[start]=true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0;i<map[now].size();i++) {
				int next = map[now].get(i); 
				if(used[next]) continue;
				
				q.add(next);
				used[next]=true;
				ans[next]++;
			}
		}
	}
}

// https://www.acmicpc.net/problem/1766
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] remains = new int[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			remains[b]++;
		}
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i < N+1; i++) {
			if(remains[i]==0) {
				pq.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now).append(" ");
			for(int i=0;i<list[now].size();i++) {
				int next = list[now].get(i);
				remains[next]--;
				if(remains[next]==0) {
					pq.add(next);
				}
			}
		}
		
		System.out.println(sb.toString());

		br.close();
		System.exit(0);
	}
}

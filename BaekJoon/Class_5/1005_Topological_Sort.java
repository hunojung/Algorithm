// https://www.acmicpc.net/problem/1005
// ACM Craft
import java.io.*;
import java.util.*;

public class Main {
	static int dust = 2;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			List<Integer>[] list = new ArrayList[N+1];
			int[] D = new int[N+1];
			int[] count = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				D[i]=Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				count[b]++;
			}
			
			int W = Integer.parseInt(br.readLine());

			Queue<Integer> q = new LinkedList<>();
			int[] time = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				time[i]=D[i];
				if(count[i]==0) q.add(i);
			}
			
			while(!q.isEmpty()){
				int now = q.poll();
				
				for (int i = 0; i < list[now].size(); i++) {
					int next = list[now].get(i);
					time[next]=Math.max(time[next], time[now]+D[next]);
					count[next]--;
					
					if(count[next]==0)
						q.add(next);
				}
			}
			
			sb.append(time[W]+"\n");
		}

		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

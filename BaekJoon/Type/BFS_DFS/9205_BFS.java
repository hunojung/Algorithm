// https://www.acmicpc.net/problem/9205
// 맥주 마시면서 걸어가기
import java.io.*;
import java.util.*;

public class Main {
	private static final Class<int[]> Comparable = null;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		// 입력
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			String res = "sad";
			int n = Integer.parseInt(br.readLine());
			int[] sang = new int[2];
			int[] festival = new int[2];
			int[][] store = new int[n][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			sang[0]=Integer.parseInt(st.nextToken());
			sang[1]=Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0]=Integer.parseInt(st.nextToken());
				store[i][1]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			festival[0]=Integer.parseInt(st.nextToken());
			festival[1]=Integer.parseInt(st.nextToken());
			boolean[] visit = new boolean[n];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {sang[0],sang[1]});
			while(!q.isEmpty()){
				int[] now = q.poll();
				int goalLen = Math.abs(festival[0]-now[0])+Math.abs(festival[1]-now[1]);
				//System.out.println(now[0]+" "+now[1]+" "+goalLen);
				if(goalLen<=1000){
					res="happy";
					break;
				}
				
				for (int i = 0; i < n; i++) {
					int nowLen = Math.abs(now[0]-store[i][0])+Math.abs(now[1]-store[i][1]);
					//int nextLen = Math.abs(festival[0]-store[i][0])+Math.abs(festival[1]-store[i][1]);
					//System.out.println(store[i][0]+" "+store[i][1]+" "+nowLen+" "+nextLen);
					if(!visit[i] && nowLen<=1000){
						q.add(new int[] {store[i][0],store[i][1]});
						visit[i]=true;
					}
				}
			}
			
			sb.append(res+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

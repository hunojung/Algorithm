// https://www.acmicpc.net/problem/1202
// 보석 도둑
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] jwl = new int[N][2];
		int[] bag = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jwl[i][0]=m;
			jwl[i][1]=v;
		}
		
		for (int i = 0; i < K; i++) {
			bag[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);
		Arrays.sort(jwl,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		long sum = 0;
		int idx =0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<K;i++){
			for (int j = idx; j < N; j++) {
				if(jwl[j][0]>bag[i])
					break;
				pq.add(jwl[j][1]);
				idx++;
			}
			
			if(!pq.isEmpty())
				sum+=pq.poll();
		}
		
		System.out.println(sum);
		br.close();
		System.exit(0);
	}
}

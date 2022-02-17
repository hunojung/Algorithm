// https://www.acmicpc.net/problem/12865
// 평범한 배낭
import java.io.*;
import java.util.*;

public class Main {
	static int res;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] sejoon = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sejoon[i][0] = Integer.parseInt(st.nextToken());
			sejoon[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[K+1];
		for (int i = 0; i < N; i++) {
			for (int j = K; j > -1; j--) {
				int energy = sejoon[i][0]+j;
				if(energy<K+1){
					dp[energy] = Math.max(dp[energy], dp[j]+sejoon[i][1]);
				}
			}
		}
		
		System.out.println(dp[K]);
		br.close();
		System.exit(0);
	}
}

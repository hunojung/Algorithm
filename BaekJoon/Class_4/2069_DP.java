// https://www.acmicpc.net/problem/2096
// 내려가기
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		int[][] dp_min = new int[N+1][3];
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			dp[i][0]=a+Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1]=b+Math.max(dp[i-1][0], Math.max(dp[i-1][1],dp[i-1][2]));
			dp[i][2]=c+Math.max(dp[i-1][2], dp[i-1][1]);

			dp_min[i][0]=a+Math.min(dp_min[i-1][0], dp_min[i-1][1]);
			dp_min[i][1]=b+Math.min(dp_min[i-1][0], Math.min(dp_min[i-1][1],dp_min[i-1][2]));
			dp_min[i][2]=c+Math.min(dp_min[i-1][2], dp_min[i-1][1]);
		}

		int max = Math.max(dp[N][0],Math.max(dp[N][1],dp[N][2]));
		int min = Math.min(dp_min[N][0],Math.min(dp_min[N][1],dp_min[N][2]));
		System.out.println(max+" "+min);
		br.close();
		System.exit(0);
	}
}

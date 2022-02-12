// https://www.acmicpc.net/problem/11054
// 가장 긴 바이토닉 부분 수열
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][N];
		int res = 1;
		for (int i = 0; i < N; i++) {
			dp[i][0]=1;
			if(N>1)dp[N-1-i][1]=1;
			for (int j = 0; j < i; j++) {
				if(nums[j]<nums[i] && dp[i][0]<=dp[j][0])
					dp[i][0] = dp[j][0]+1;

				if(nums[N-1-j]<nums[N-1-i] && dp[N-1-i][1]<=dp[N-1-j][1])
					dp[N-1-i][1] = dp[N-1-j][1]+1;
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			//System.out.println(dp[i][0]+" "+dp[i][1]);
			if(N>1)res = Math.max(res, dp[i][0]+dp[i][1]-1);
		}
		System.out.println(res);
		br.close();
		System.exit(0);
	}
}

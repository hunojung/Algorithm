// https://www.acmicpc.net/problem/11053
// 가장 긴 증가하는 부분 수열
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
		
		int[] dp = new int[N];
		dp[0]=1;
		int res = 1;
		for (int i = 1; i < N; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if(nums[j]<nums[i] && max<dp[j])
					max = dp[j];
			}
			dp[i]=max+1;
			if(dp[i]>res)res=dp[i];
		}
		System.out.println(res);
		br.close();
		System.exit(0);
	}
}

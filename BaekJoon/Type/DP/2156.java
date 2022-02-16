// https://www.acmicpc.net/problem/2156
// 포도주 시식
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		int[] dp= new int[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if(i<3)
				dp[i]=dp[i-1]+nums[i];
			else
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+nums[i-1]+nums[i],dp[i-2]+nums[i]));
		}
		
		System.out.println(dp[N]);
		br.close();
		System.exit(0);
	}
}

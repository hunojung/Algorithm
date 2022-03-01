// https://www.acmicpc.net/problem/11052
// 카드 구매하기
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N+1];
		int[] dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			P[i]=Integer.parseInt(st.nextToken());
			dp[i]=P[i];
		}
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i]=Math.max(dp[i],dp[i-j]+dp[j]);
			}
		}
		System.out.println(dp[N]);
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/problem/1912
// 연속합
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp= new int[N+1];
		int max = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(i==0)max=num;
			dp[i+1]=Math.max(dp[i]+num, num);
			if(max<dp[i+1])max=dp[i+1];
		}
		System.out.println(max);
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/submit/2616/38158788
// 소형기관차

// 분류
// 다이나믹 프로그래밍
// 누적 합
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] train = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			train[i]=train[i-1]+Integer.parseInt(st.nextToken());
		}
		
		int size = Integer.parseInt(br.readLine());
		int[][] dp = new int[4][N+1];
		for (int i = 1; i < 4; i++) {
			for (int j = size; j < N+1; j++) {
				dp[i][j]=Math.max(dp[i][j-1],
						dp[i-1][j-size]+train[j]-train[j-size]);
			}
		}
		System.out.println(dp[3][N]);
		
		br.close();
		System.exit(0);
	}
}

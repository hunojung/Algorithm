// https://www.acmicpc.net/problem/9465
// 스티커
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map,air;
	static int oneCount;
	static int[] dh = {0,1,0,-1},dw = {1,0,-1,0};
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			int[][] dp = new int[2][n+1];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				sticker[0][i]=Integer.parseInt(st1.nextToken());
				sticker[1][i]=Integer.parseInt(st2.nextToken());
			}
			dp[0][1]=sticker[0][0];
			dp[1][1]=sticker[1][0];
			for (int i = 2; i < n+1; i++) {
				dp[0][i]=Math.max(dp[1][i-2], dp[1][i-1])+sticker[0][i-1];
				dp[1][i]=Math.max(dp[0][i-2], dp[0][i-1])+sticker[1][i-1];
			}
			
			sb.append(Math.max(dp[0][n], dp[1][n])+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

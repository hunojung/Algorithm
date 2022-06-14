// 계단수
// https://www.acmicpc.net/problem/1562
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int MOD = 1000000000;
		
		long[][][] dp = new long[num][10][1024];
		
		for (int i = 1; i < 10; i++) {
			dp[0][i][1<<i] = 1;
		}
		
		for (int i = 1; i < num; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1024; k++) {
					int bit = k|(1<<j);
					if(j==0) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k])%MOD;
					}else if(j==9) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k])%MOD;
					}else {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]+dp[i-1][j+1][k])%MOD;
					}
					
				}
			}
		}
		
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[num-1][i][1023]) % MOD;
		}
		
		System.out.println(sum);

		br.close();
		System.exit(0);
	}
}

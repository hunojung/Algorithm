// https://www.acmicpc.net/problem/1932
// 정수 삼각형

// 분류
// 다이나믹 프로그래밍
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				dp[i][j]=Integer.parseInt(st.nextToken());
			}
		}
        
        int max = dp[0][0];
        for (int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				if(j==0){
					dp[i][j]=dp[i-1][j]+dp[i][j];
				}else if(j==i){
					dp[i][j]=dp[i-1][j-1]+dp[i][j];
				}else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+dp[i][j];
				}
				if(dp[i][j]>max)max=dp[i][j];
			}
		}
        System.out.println(max);
        
        br.close();
		System.exit(0);
	}
}

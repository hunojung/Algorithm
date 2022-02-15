// https://www.acmicpc.net/problem/1932
// 정수 삼각형
import java.io.*;
import java.util.*;

public class Main {
	static int min = Integer.MAX_VALUE, count = 1;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int[][] dp = new int[N+1][N+1];
		for(int i=1; i<N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<i+1;j++){
				int num = Integer.parseInt(st.nextToken());
				if(j==0){
					dp[i][j]=dp[i-1][j]+num;
				}else if(j==i){
					dp[i][j]=dp[i-1][j-1]+num;
				}else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+num;
				}
				if(max<dp[i][j])max=dp[i][j];
			}
		}
		System.out.println(max);
		br.close();
		System.exit(0);
	}
}

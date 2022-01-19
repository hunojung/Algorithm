// https://www.acmicpc.net/problem/1958
// LSC 3

// 분류
// 다이나믹 프로그래밍
// 문자열
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
		//int answer = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				for (int k = 0; k < s3.length(); k++) {
					if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
						
            // 일치할 경우 1 증가, 대각선에서 +1 하는 것이기 때문에 여러번 일치되어도 1증가된 것만 계속 됨
						dp[i+1][j+1][k+1] = dp[i][j][k]+1;
					}else{
            
            // 누적된 값들을 이어간다
						dp[i+1][j+1][k+1] = Math.max(dp[i][j+1][k+1], Math.max(dp[i+1][j][k+1], dp[i+1][j+1][k]));
					}
					
				}
			}
		}
		
		System.out.println(dp[s1.length()][s2.length()][s3.length()]);

		br.close();
		System.exit(0);
	}
}

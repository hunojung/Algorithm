// https://www.acmicpc.net/problem/9252
// LCS 2

// 분류
// 다이나믹 프로그래밍
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		String s1 = br.readLine();
		String s2 = br.readLine();
		String[][] dp = new String[s1.length()+1][s2.length()+1];
		
		for (int i = 0; i < s1.length()+1; i++) {
			dp[i][0]="";
		}
		for (int i = 0; i < s2.length()+1; i++) {
			dp[0][i]="";
		}
		
		//int answer = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if(s1.charAt(i) == s2.charAt(j)){
					// 일치할 경우 1 증가, 대각선에서 +1 하는 것이기 때문에 여러번 일치되어도 1증가된 것만 계속 됨
					dp[i+1][j+1] = dp[i][j]+s1.charAt(i);
				}else{
        
					// 누적된 값들을 이어간다
					dp[i+1][j+1] = dp[i][j+1].length()>dp[i+1][j].length()?dp[i][j+1]:dp[i+1][j];
				}
			}
		}
		
		System.out.println(dp[s1.length()][s2.length()].length());
		if(dp[s1.length()][s2.length()].length()!=0)System.out.println(dp[s1.length()][s2.length()]);
		br.close();
		System.exit(0);
	}
}

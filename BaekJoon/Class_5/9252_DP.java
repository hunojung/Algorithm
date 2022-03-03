// https://www.acmicpc.net/problem/9252
// LCS 2
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s1 = br.readLine();
		String s2 = br.readLine();
		int idx1 = s1.length();
		int idx2 = s2.length();
		
		int[][] dp = new int[idx1+1][idx2+1];
		for (int i = 0; i < idx1; i++) {
			for (int j = 0; j < idx2; j++) {
				if(s1.charAt(i)==s2.charAt(j)){
					dp[i+1][j+1]=dp[i][j]+1;
				}else{
					if(dp[i+1][j]>dp[i][j+1]){
						dp[i+1][j+1]=dp[i+1][j];
					}else{
						dp[i+1][j+1]=dp[i][j+1];
					}
				}
				//System.out.print(dp[i+1][j+1]+" ");
			}
			//System.out.println("");
		}

		int length = dp[idx1][idx2];
		System.out.println(length);

		if(length!=0){
			while(idx1!=0 && idx2!=0){
				if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){
					sb.append(s1.charAt(idx1-1));
					idx1--;
					idx2--;
				}else if(dp[idx1][idx2] == dp[idx1-1][idx2]){
					idx1--;
				}else{
					idx2--;
				}
			}
			
			System.out.println(sb.reverse().toString());
		}
		
		br.close();
		System.exit(0);
	}
}

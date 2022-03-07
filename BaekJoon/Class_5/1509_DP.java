// https://www.acmicpc.net/problem/1509
// 팰리드롬 분할

// first submit
import java.io.*;
import java.util.*;

// AAACCACACAAACCACAC : 5
public class Main {
	static int ans = 0;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		
		boolean[][] ok = new boolean[n][n];
		ok[0][0]=true;
		
		// 1개, 2개짜리 팰린드롬 찾기
		for (int i = 1; i < n; i++){ 
			ok[i][i]=true;
			if(s.charAt(i-1)==s.charAt(i))
				ok[i-1][i]=true;
		}
		
		// 2개짜리부터 퍼져나간다
		for (int i = 2; i < n; i++) {
			for (int j = 0; j+i < n; j++) {
				if(ok[j+1][i+j-1])
					if(s.charAt(j)==s.charAt(i+j))
						ok[j][i+j]=true;
			}
		}
			
		int[] dp = new int[n];
		dp[0]=1;
		for (int i = 1; i < n; i++) {
			dp[i]=dp[i-1]+1;
			if(ok[0][i]){
				dp[i]=1;
				continue;
			}
			// palindrome일 경우 모두 훑어보고 min값으로 결정
			for (int j = 1; j <i ; j++) {
				if(ok[j][i])
					dp[i]=Math.min(dp[i],dp[j-1]+1);
			}
		}
		
		System.out.println(dp[n-1]);
		br.close();
		System.exit(0);
	}
}

// second submit
import java.io.*;
import java.util.*;

// AAACCACACAAACCACAC : 5
public class Main {
	static int ans = 0;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int[] dp = new int[len];
		dp[0]=1;
		for (int i = 1; i < len; i++) {
			dp[i]=dp[i-1]+1;
			for (int j = 0; j <i ; j++) {

				// palindrome일 경우 모두 훑어보고 min값으로 결정
				if(palindrome(s,j,i)){
					if(j==0) dp[i]=1;
					else dp[i]=Math.min(dp[i],dp[j-1]+1);
				}
			}
		}
		
		System.out.println(dp[len-1]);
		br.close();
		System.exit(0);
	}
	
	static boolean palindrome(String s , int idx1, int idx2){
		while(idx1<idx2){
			if(s.charAt(idx1)!=s.charAt(idx2)){
				return false;
			}
			idx1++;
			idx2--;
		}
		return true;
	}
}

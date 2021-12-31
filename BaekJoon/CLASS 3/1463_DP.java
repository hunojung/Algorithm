// 1로 만들기
// 1463
package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int number = Integer.parseInt(br.readLine());

		
		int[] dp = new int[number+1]; // Integer 일 경우 null로 초기화 됨
		
		for (int N = 2; N < number+1; N++) {
			dp[N]=dp[N-1]+1;
			if(N%2==0)dp[N]=Math.min(dp[N], dp[N/2]+1);
			if(N%3==0)dp[N]=Math.min(dp[N], dp[N/3]+1);
		}
		
		System.out.println(dp[number]);
		
		br.close();
		System.exit(0);
	}
}
// 1463 END

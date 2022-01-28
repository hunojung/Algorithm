// https://www.acmicpc.net/problem/1720
// 타일 코드

// 분류
// 수학
// 다이나믹 프로그래밍
// 조합론
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1]; 
		int[][] dp2 = new int[N+1][2];
        
		dp[1]=1;
		if(N>1)dp[2]=3;
		if(N>2)dp[3]=3;
		if(N>3)dp[4]=8;
		
		// 0은 총 합 1은 대칭인 것의 갯수
		dp2[1][0]=1;
		if(N>1)dp2[2][0]=3;
		if(N>2)dp2[3][0]=5;
		if(N>3)dp2[4][0]=11;

		dp2[1][1]=1;
		if(N>1)dp2[2][1]=3;
		if(N>2)dp2[3][1]=1;
		if(N>3)dp2[4][1]=5;
		
		// lll n개/ l+(n-2)항대칭+l / =+(n-4)항대칭+= / ㅁ+(n-4)항대칭+ㅁ 이거는 대칭 아닌거 확실
		// 대칭인 것들의 갯수들만 따로모은다
		// (n총합 -n대칭)/2+n대칭 하면 결과가 나온다.
		for (int i = 5; i < N+1; i++) {
			dp2[i][0]=dp2[i-1][0]+2*dp2[i-2][0];
			dp2[i][1]=dp2[i-2][1]+dp2[i-4][1]*2;
			dp[i]=(dp2[i][0]-dp2[i][1])/2+dp2[i][1];
		}
		
		System.out.println(dp[N]);
		
		br.close();
		System.exit(0);
	}
}

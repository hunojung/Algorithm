// https://www.acmicpc.net/problem/14002
// 가장 긴 증가하는 부분 4

// 분류
// 다이나믹 프로그래밍
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		// dp의 각 칸에는 해당 인덱스가 마지막일 경우의 최대 len
		int[] dp = new int[N+1];
		int[] index = new int[N+1];
		int bigIndex = 0;
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]){
					// arr[i]는 arr[j]보다 크니까 arr[j]+1 한다 그런데
					// 기존에 dp[i]가 dp[j]보다 한참 크면 냅둔다
					if(dp[j]+1>dp[i]){
						dp[i]=dp[j]+1;
						index[i]=j;					
					}
					// result는 가장 큰 dp값
					if(dp[i]>result){
						result = dp[i];
						bigIndex = i;
					}
				}
			}
		}
		sb.append(result+"\n");
		int[] answer = new int[result];
		for (int i = 0; i < result; i++) {
			answer[i]=arr[bigIndex];
			bigIndex=index[bigIndex];
		}
		for (int i = result-1; i >-1; i--) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

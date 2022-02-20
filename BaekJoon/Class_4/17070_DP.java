// https://www.acmicpc.net/problem/17070
// 파이프 옮기기 1
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		// 0 가로 / 1 대각선 / 2 세로
		int[][][] dp = new int[N+1][N+1][3];
		dp[1][2][0]=1;
		for (int i = 1; i < N+1; i++) {
			for (int j = 2; j < N+1; j++) {
				if(map[i][j]==1) continue;
				
				dp[i][j][0]+=dp[i][j-1][0]+dp[i][j-1][1];
				dp[i][j][2]+=dp[i-1][j][1]+dp[i-1][j][2];
				if(map[i-1][j]+map[i][j-1]==0)
					dp[i][j][1]+=dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
			}
		}
		
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
		br.close();
		System.exit(0);
	}
}

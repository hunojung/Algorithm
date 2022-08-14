// https://www.acmicpc.net/problem/2098
import java.io.*;
import java.util.*;

public class Main {
	static int N,INF = 20000000,allVisited;
	static int[][] map, dp;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		allVisited = (1<<N)-1;
		dp = new int[N][allVisited];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0,1));
		
		br.close();
		System.exit(0);
	}
	
	static int dfs(int start,int visited) {
		// 모든곳 다 돌았으면
		if(visited == allVisited) {
			return map[start][0] == 0?INF:map[start][0];
		}
		
		if(dp[start][visited] > 0) {
			return dp[start][visited];
		}
		
		dp[start][visited] = INF;
		
		for (int i = 0; i < N; i++) {
			if( (visited & (1<<i)) > 0 || map[start][i] == 0) continue;

			dp[start][visited] = Math.min(dp[start][visited], dfs(i,visited|(1<<i))+map[start][i]);
			
		}
		
		return dp[start][visited];
	}
}

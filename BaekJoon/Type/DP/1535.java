// https://www.acmicpc.net/problem/1535
// 안녕
import java.io.*;
import java.util.*;

public class Main {
	static int res;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int hp = 100;
		int[][] sejoon = new int[N][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sejoon[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sejoon[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[100];
		for (int i = 0; i < N; i++) {
			for (int j = 99; j > -1; j--) {
				int energy = sejoon[i][0]+j;
				if(energy<100){
					dp[energy] = Math.max(dp[energy], dp[j]+sejoon[i][1]);
				}
			}
		}
		
		System.out.println(dp[99]);
		br.close();
		System.exit(0);
	}
}

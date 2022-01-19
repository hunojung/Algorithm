// https://www.acmicpc.net/problem/1149
// RGB 거리

// 분류
// 다이나믹 프로그래밍
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		int ans = 0;
		
		// 입력 한번 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 인덱스에서 최솟값을 계속 더해가기
		for (int n = 1; n < N; n++) {
			for (int i = 0; i < 3; i++) {
				if(i==0){
					house[n][i]=Math.min(house[n-1][1], house[n-1][2])+house[n][i];
				}else if(i==1){
					house[n][i]=Math.min(house[n-1][0], house[n-1][2])+house[n][i];
				}else{
					house[n][i]=Math.min(house[n-1][1], house[n-1][0])+house[n][i];
				}
			}
		}
		
		System.out.println(Math.min(house[N-1][0], Math.min(house[N-1][1], house[N-1][2])));
		br.close();
		System.exit(0);
	}
}

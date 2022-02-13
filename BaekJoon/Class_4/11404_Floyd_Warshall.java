// https://www.acmicpc.net/problem/11404
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		for(int i = 0 ; i < m ; i++ ){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(map[a][b]==0){
				map[a][b]=c;
			}else{
				map[a][b]=Math.min(map[a][b], c);
			}
		}
		
		// k : 거처가는 노드
		// i > k > j
		for(int k = 1; k < n+1;k++){
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					if(map[i][k]!=0 && map[k][j]!=0 && i!=j){
						map[i][j]=map[i][j]==0?map[i][k]+map[k][j] : Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				sb.append(map[i][j]+" ");
			}sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

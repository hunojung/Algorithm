// https://www.acmicpc.net/problem/14938
// 서강그라운드
import java.io.*;
import java.util.*;

public class Main {
	static int X = 1000000007;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		int[] item = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			item[i+1]=Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			map[a][b]=l;
			map[b][a]=l;
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(map[j][i]==0)continue;
				for (int k = 1; k < n+1; k++) {
					if(j==k || map[i][k]==0)continue;
					if(map[j][k]==0 || map[j][k]>map[j][i]+map[i][k]){
						map[j][k]=map[j][i]+map[i][k];
						map[k][j]=map[j][k];
					}
				}
			}
		}
		int max = 0;
		for (int i = 1; i < n+1; i++) {
			int sum = 0;
			for (int j = 1; j < n+1; j++) {
				if(i==j || (map[i][j]<=m &&map[i][j]!=0) )sum+=item[j];
			}
			max=Math.max(sum, max);
		}
		
		System.out.println(max);
		br.close();
		System.exit(0);
	}
}

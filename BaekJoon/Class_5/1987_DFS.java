// https://www.acmicpc.net/problem/1987
// 알파벳
import java.util.*;
import java.io.*;

public class Main {
	static int answer;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		answer = 0;
		int[][] arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j]=s.charAt(j)-'A';
			}
		}
		
		boolean[] visit = new boolean[26];
		visit[arr[0][0]]=true;
		dfs(arr,0,0,1,visit);
		
		System.out.println(answer);

		br.close();
		System.exit(0);
	}
	
	static void dfs(int[][] arr,int r, int c,int length,boolean[] visit) {
		
		answer = Math.max(answer,length);
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>-1 && nr<arr.length && nc>-1 && nc<arr[0].length && !visit[arr[nr][nc]]) {
				visit[arr[nr][nc]]=true;
				dfs(arr,nr,nc,length+1,visit);
				visit[arr[nr][nc]]=false;
			}
		}
	}
}

// https://www.acmicpc.net/problem/2239
// 스도쿠
import java.util.*;
import java.io.*;

public class Main {
	static boolean complete = false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[10][10];
		
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = line.charAt(j)-'0'; 
			}
		}
		
		backTracking(arr,0,0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		br.close();
		System.exit(0);
	}
	
	static void backTracking(int[][] arr,int m,int n) {
		if(n>8) {
			n = 0;
			m++;
			if(m>8) {
				complete = true;
				return;
			}
		}
		
		if(arr[m][n]>0) {
			backTracking(arr,m,n+1);
			return;
		}
		
		boolean[] used = new boolean[10];
		
		for (int i = 0; i < 9; i++) {
			used[arr[m][i]]=true;
			used[arr[i][n]]=true;
		}

		int h = (m/3)*3;
		int w = (n/3)*3;
		for (int i = h; i < h+3; i++) {
			for (int j = w; j < w+3; j++) {
				used[arr[i][j]]=true;
			}
		}
		
		for (int i = 1; i < 10; i++) {
			if(used[i]) continue;
			
			arr[m][n] = i;
			backTracking(arr,m,n+1);
			if(complete) return;
			arr[m][n] = 0;
		}
	}
}

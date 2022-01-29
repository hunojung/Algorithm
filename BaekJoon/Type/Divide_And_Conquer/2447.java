// https://www.acmicpc.net/problem/2447
// 별 찍기 - 10

// 분류
// 분할 정복
// 재귀
import java.io.*;
import java.util.*;

public class Main{
	static boolean[][] start;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		start = new boolean[N][N];
		dvide(N,0,0,true);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(start[i][j])sb.append('*');
				else sb.append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void dvide(int N, int x,int y,boolean ok){
		if(N==1){
			start[x][y]=ok;
		}else if(N>=3 && ok){
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i*j==1)dvide(N/3,x+N/3*i,y+N/3*j,false);
					else dvide(N/3,x+N/3*i,y+N/3*j,true);
				}
			}
		}
	}
}

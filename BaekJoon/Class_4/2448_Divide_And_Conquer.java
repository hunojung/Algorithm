// https://www.acmicpc.net/problem/2448
// 별 찍기 - 11
import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new char[N+1][2*N];

		star(N,N,2*N);
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < 2*N; j++) {
				if(map[i][j]=='*'){
					sb.append(map[i][j]);
				}else{
					sb.append(' ');
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void star(int size,int h,int w){
		if(size==3){
			for (int i = w-1; i >w-6 ; i--) {
				map[h][i]='*';
			}
			map[h-1][w-2]='*';
			map[h-1][w-4]='*';
			map[h-2][w-3]='*';
			
		}else{
			star(size/2,h,w);
			star(size/2,h,w-size);
			star(size/2,h-(size/2),w-(size/2));
		}
	}
}

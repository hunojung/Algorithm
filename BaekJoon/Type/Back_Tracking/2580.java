// https://www.acmicpc.net/problem/2580
// 스도쿠

// 분류
// 
import java.io.*;
import java.util.*;

public class Main{
	static int[][] map=new int[9][9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		br.close();
		System.exit(0);
	}
	
	static void dfs(int i_s, int j_s){
		if(i_s==8 && j_s>8){
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]+" ");
				}System.out.println("");
			}
			System.exit(0);
		}else if(j_s>8){
			dfs(i_s+1,0);
            return;
		}
		
		if(map[i_s][j_s]==0){
			// 1~9 숫자 있나 확인 
			// 가로, 세로, 네모칸
			for (int k = 1; k<10; k++) {
				boolean exist = false;
				for (int n = 0; n < 9; n++) {
					if(map[i_s][n]==k || map[n][j_s]==k){
						exist = true;
						break;
					}
					if(exist)break;
				}
				
				if(!exist){
					int xs = (i_s/3)*3;
					int ys = (j_s/3)*3;
					for (int l = 0; l < 3; l++) {
						for (int l2 = 0; l2 < 3; l2++) {
							if(map[xs+l][ys+l2]==k){
								exist=true;
								break;
							}
							if(exist)break;
						}
					}
				}
				
				if(!exist){
					map[i_s][j_s]=k;
					dfs(i_s,j_s+1);
					map[i_s][j_s]=0;
				}
			}
		}else{
			dfs(i_s,j_s+1);
		}
	}
}

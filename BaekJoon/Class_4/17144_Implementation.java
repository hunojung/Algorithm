// https://www.acmicpc.net/problem/17144
// 미세먼지 안녕!
import java.io.*;
import java.util.*;

public class Main {
	static int dust = 2;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int airPos = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				dust+=map[i][j];
				if(map[i][j]==-1){
					if(airPos==0){
						airPos=i;
					}
				}
			}
		}
		
		while(T-->0){
			dust(map);
			airClean(map,airPos);
		}
		

		System.out.println(dust);
		br.close();
		System.exit(0);
	}
	
	static void airClean(int[][] map,int airPos){
		// 공기청정기 방향 두개
		int[][] dr = {{-1,0,1,0},{1,0,-1,0}};
		int[][] dc = {{0,1,0,-1},{0,1,0,-1}};
		
		// 공기청정기 두개 순서대로
		for (int i = 0; i < 2; i++) {
			int r = airPos+i+dr[i][0];
			int c = 0;
			dust-=map[r][c];
			
			int turn = 0;
			while(map[r][c]!=-1){
				//System.out.println(r+" "+c);
				int nextr = r+dr[i][turn];
				int nextc = c+dc[i][turn];
				if(map[nextr][nextc]==-1){
					map[r][c]=0;
				}else{
					map[r][c]=map[nextr][nextc];
				}
				r = nextr;
				c = nextc;
				
				if(r==0 || r == map.length-1)
					turn = 1;
				
				if(c==map[0].length-1)
					turn = 2;
				
				if(r==airPos+i)
					turn = 3;
			}
		}
	}
	
	static void dust(int[][] map){
		int[][] addDust = new int[map.length][map[0].length];
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]>0){
					int add = 0;
					for (int k = 0; k < 4; k++) {
						int r = i+dr[k];
						int c = j+dc[k];
						if(r>-1 && r<map.length && c>-1 && c<map[0].length && map[r][c]!=-1){
							addDust[r][c] += map[i][j]/5;
							add += map[i][j]/5;
						}
					}
					map[i][j]-=add;
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j]+=addDust[i][j];
			}
		}
	}
}

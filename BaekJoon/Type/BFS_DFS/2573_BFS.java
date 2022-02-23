// https://www.acmicpc.net/problem/2573
// 빙산
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[] dh = {1,0,-1,0};
	static int[] dw = {0,1,0,-1};
	static int N,M,allIce=0;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				allIce+=map[i][j];
			}
		}
		int year = 0;
		while(!isTwoPart() && allIce>0){
			year++;
			afterYear();
		}
		
		if(allIce==0)
			System.out.println(0);
		else
			System.out.println(year);

		br.close();
		System.exit(0);
	}
	
	static void afterYear(){
		int[][] ice = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>0){
					int count=map[i][j];
					for (int k = 0; k < 4; k++) {
						if(map[i+dh[k]][j+dw[k]]==0 && count>0){
							count--;
							allIce--;
						}
					}
					ice[i][j]=count;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>0){
					map[i][j]=ice[i][j];
				}
			}
		}
	}
	
	static boolean isTwoPart(){
		boolean twoPart = false;
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0 && !visit[i][j]){
					if(twoPart){
						return true;
					}else{
						twoPart=true;
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] {i,j});
						visit[i][j]=true;
						while(!q.isEmpty()){
							int[] next = q.poll();
							for (int k = 0; k < 4; k++) {
								int h = next[0]+dh[k];
								int w = next[1]+dw[k];
								// 첫째, 마지막 행과열은 얼음 없다니까 조건문 빼기
								if(map[h][w]>0&&!visit[h][w]){
									q.add(new int[] {h,w});
									visit[h][w]=true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}

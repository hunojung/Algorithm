// https://www.acmicpc.net/problem/17136
// 색종이 붙이기

// 분류
// 브루트포스 알고리즘
// 백트래킹
import java.io.*;
import java.util.*;

public class Main{
	static int[][] map = new int[10][10];
	static int[] page12345={0,5,5,5,5,5};
	static int allOne = 0;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1)allOne++;
			}
		}
		
		dfs(0,0,0);
		
		if(ans!=Integer.MAX_VALUE)System.out.println(ans);
		else System.out.println(-1);
		
		br.close();
		System.exit(0);
	}
	
	// N은 종이 크기 5,4,3,2,1 들어올수 있음
	static void dfs(int cnt,int x,int y){
		// map 돌아다니며 종이 붙이기 반복
		
		if(allOne==0){
			if(ans>cnt)ans = cnt;
			return;
		}
		
		// 최솟값보다 붙인 수가 크면 바로 끝
		if(ans<=cnt){
			return;
		}
		
		if(x>9){
			return;
		}else if(x<9 && y>9){
			x++;
			y=0;
		}
		

		if(map[x][y]==1){
			// 카드 큰거붙여 하나씩 붙여봄
			for (int n = 5; n > 0; n--) {
				
				// 1이고 종이 붙일 수 있는지 확인
				if(page12345[n]>0 && possible(n,x,y)){
					paper(n,x,y,0); // 붙여
					
					dfs(cnt+1,x,y+1);
					
					paper(n,x,y,1); // 떼
				}
			}
		}else{
			dfs(cnt,x,y+1);
		}
	}

	// 붙였다 뗏다
	static void paper(int N,int x, int y, int state){
		if(state==1){
			allOne+=(N*N);
			page12345[N]++;
		}else{
			allOne-=(N*N);
			page12345[N]--;
		}
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				map[i][j]=state;
			}
		}
	}
	
	// NxN 종이 들어가는지 확인
	static boolean possible(int N,int x, int y){
		if(x+N>10 || y+N>10)return false;
		
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if(map[i][j]==0){
					return false;
				}
			}
		}
		return true;
	}
}

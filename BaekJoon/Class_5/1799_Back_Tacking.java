// https://www.acmicpc.net/problem/1799
// 흑/백 칸 따로 계산해서 시간을 단축하는게 포인트
import java.util.*;
import java.io.*;

public class Main {
	static int max1,max2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if(st.nextToken().equals("1")) {
					map[i][j] = true;
				}
			}
		}
		max1 = 0;
		max2 = 0;
		backTracking(true,map,new boolean[N*2],new boolean[N*2],N,0,0,0);
		backTracking(false,map,new boolean[N*2],new boolean[N*2],N,0,1,0);
		
		System.out.println(max1+max2);
		br.close();
		System.exit(0);
	}
	
	static void backTracking(boolean isBlack,boolean[][] map, boolean[] right, boolean[] left,int N, int h, int w, int count) {
		//System.out.println(idx);
		if(isBlack) max1 = Math.max(max1, count);
		else max2 = Math.max(max2, count);
		
		
		if(w>=N) {
			if(isBlack) {
				h++;
				w = h%2==0?0:1;
			}else {
				h++;
				w = h%2==0?1:0;
			}
		}

		if(h>=N) return;
		
		if(map[h][w]==true) {
			
			if(right[(N-1)-h+w]==false && left[h+w]==false) {
				
				right[(N-1)-h+w] = true;
				left[h+w] = true;
				backTracking(isBlack,map,right,left,N,h,w+2,count+1);
				right[(N-1)-h+w] = false;
				left[h+w] = false;
			}
		}
		
		backTracking(isBlack,map,right,left,N,h,w+2,count);
	}
}

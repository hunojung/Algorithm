// https://www.acmicpc.net/problem/9663
// N-Queen
import java.io.*;
import java.util.*;

// 0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596
public class Main {
	static int N, answer=0;
	static boolean[] pCross,mCross,h;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		N = Integer.parseInt(br.readLine());
		pCross = new boolean[2*N-1];
		mCross = new boolean[2*N-1];
		h = new boolean[N];
		// 가로, 세로 N개 선택
		// 양수 ,음수 대각선 N개
		dfs(0);
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
	
	static void dfs(int w){
		if(w==N){
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if(h[i] || pCross[i+w] || mCross[(N-1)+w-i])
				continue;
			
			//System.out.println(w+" "+i);
			h[i]=true;
			pCross[i+w]=true;
			mCross[(N-1)+w-i]=true;
			
			dfs(w+1);
			
			h[i]=false;
			pCross[i+w]=false;
			mCross[(N-1)+w-i]=false;
		}
	}
}

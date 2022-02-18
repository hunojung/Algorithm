// https://www.acmicpc.net/problem/13172
// Σ
package algorithm;

import java.io.*;
import java.util.*;

public class Main {
	static int X = 1000000007;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		long S = 0;
		int[][] p = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			S = (S+(long)a*pow(b)%X)%X;
		}
		System.out.println(S);
		br.close();
		System.exit(0);
	}

	static long pow(long b){
		long S = 1;
		int x = X-2;
		while(x>0){
			while(x%2==0){
				b = b*b%X;
				x/=2;
			}
			S = S*b%X;
			x--;
		}
		return S;
	}
}

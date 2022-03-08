// https://www.acmicpc.net/problem/20040
// 사이클 게임
import java.io.*;
import java.util.*;

public class Main {
	static int ans = 0;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] g = new int[n];
		
		for (int i = 0; i < n; i++) {
			g[i]=i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			a = find(g,a);
			b = find(g,b);
			if(a == b){
				ans = i+1;
				break;
			}else{
				g[b] = a;
			}
		}
		System.out.println(ans);
		br.close();
		System.exit(0);
	}
	
	static int find(int[] g,int n){
		if(g[n]==n) return n;
		return g[n] = find(g,g[n]);
	}
}

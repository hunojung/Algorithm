// https://www.acmicpc.net/problem/10216
// Count Circle Groups

// 두번째 풀이
package algorithm;

import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			int N = Integer.parseInt(br.readLine());
			int[] g = new int[N];
			int[][] map = new int[N][3];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
				map[i][2] = Integer.parseInt(st.nextToken());
				g[i]=i;
			}
			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					int x = map[i][0]-map[j][0];
					int y = map[i][1]-map[j][1];
					int c = map[i][2]+map[j][2];
					if(x*x+y*y<=c*c)
						g[find(g,i)]=find(g,j);
				}
			}
			
			int count = 0 ;
			for (int i = 0; i < N; i++) {
				if(g[i]==i)
					count++;
			}
			
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static int find(int[] g,int n){
		if(g[n]==n)
			return n;
		
		return find(g,g[n]);
	}
}

// 첫번째 풀이
import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static boolean[] visit;
	static List<int[]> list;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new int[] {x,y,c});
			}
			
			int count = 0 ;
			visit = new boolean[list.size()];
			for (int i = 0; i < list.size(); i++) {
				if(visit[i])continue;
				count++;
				visit[i]=true;
				dfs(i);
			}
			
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void dfs(int idx){
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		int c = list.get(idx)[2];
		for (int i = 0; i <list.size(); i++) {
			if(visit[i])continue;
			
			int x1 = list.get(i)[0];
			int y1 = list.get(i)[1];
			int c1 = list.get(i)[2];
			
			int len = (x-x1)*(x-x1)+(y-y1)*(y-y1);
			if(len<=(c+c1)*(c+c1)){
				visit[i]=true;
				dfs(i);
			}
		}
	}
}

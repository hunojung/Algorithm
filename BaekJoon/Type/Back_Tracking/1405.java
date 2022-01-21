// https://www.acmicpc.net/problem/1405
// 미친로봇

// 분류
// 그래프 이론
// 브루트포스 알고리즘
// 그래프 탐색
// 깊이 우선 탐색
// 백트래킹
import java.io.*;
import java.text.Format;
import java.util.*;

public class Main{
	static int N;
	static double probability=0;
	static double[] direction; // 방향별 확률
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		direction = new double[4];
		map = new int[N*2+1][N*2+1];
		visit = new boolean[N*2+1][N*2+1];
		for (int i = 0; i < 4; i++) {
			direction[i] = (Double.parseDouble(st.nextToken()))/100;
		}
		
		visit[N][N]=true;
		dfs(0,N,N,1);
		
		System.out.println(String.format("%.10f",probability));
		br.close();
		System.exit(0);
	}
	
	static void dfs(int depth,int x,int y,double prob){
		
		if(depth==N){
			probability+=prob;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			//System.out.println("ok");
			if(direction[i]>0){
				int x2 = x+dx[i];
				int y2 = y+dy[i];
				if(!visit[x2][y2]){
					visit[x2][y2]=true;
					dfs(depth+1,x2,y2,prob*direction[i]);
					visit[x2][y2]=false;
				}
				
			}
		}
	}
}

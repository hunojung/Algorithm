// https://www.acmicpc.net/problem/17142
// 연구소 3

// 분류
// 그래프 이론
// 브루트포스 알고리즘
// 그래프 탐색
// 너비 우선 탐색
import java.io.*;
import java.util.*;

public class Main{
	static int[][] virus;
	static int N,M,vPossible;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[][] vPoint;
	static int[] startIndexs = {0,1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		virus = new int[N][N];
		vPoint = new int[10][2];
		vPossible = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				virus[i][j]=Integer.parseInt(st.nextToken());
				
				// 바이러스 가능 위치 2-> 0 변경
				// 바이러스 가능 위치 저장
				if(virus[i][j]==2){
					vPoint[vPossible][0]=i;
					vPoint[vPossible][1]=j;
					vPossible++;
					virus[i][j]=0;
				}
				
				// 벽 1-> MAX로 변경
				if(virus[i][j]==1){
					virus[i][j]=-1;
				}
			}
		}
		//System.out.println("vPossible : "+vPossible);
		System.out.println(dfs());
		
		br.close();
		System.exit(0);
	}
	
	// 바이러스 시작위치 받아서 몇초걸리는지 받는 메서드
	static int dfs(){
		int min = -1;
		
		// 바이러스가 있을 수 있는 위치에 따른 값 얻기

		while(true){
			int nextMin = infection(startIndexs);
			if(nextMin!=-1){
				if(min==-1)min = nextMin;
				else min = Math.min(nextMin,min);				
			}
			//System.out.println("검색한 min : "+nextMin+" , 비교 min : "+min);
			startIndexs = nextIndex(startIndexs,M-1);
			if(startIndexs == null)break;
		}
		
		return min;
	}
	
	// 바이러스 시작위치 정해주는 메서드
	// vPossible개의 위치가 있고 M개를 뽑아야함
	static int[] nextIndex(int[] s,int n){
		if(s==null)return s;
		s[n]++;
		
		// vPossible = 5 / 3 일 경우
		// 0,1,2 인덱스 최댓값은 2,3,4
		if(s[n]>vPossible-(M-n)){
			if(n==0){
				s = null;
			}else{
				s=nextIndex(s,n-1);
				if(s==null)return s;
				s[n]=s[n-1]+1;				
			}
		}
		
		return s;
	}
	
	// 바이러스 시작위치를 받으면
	// 시작위치에 바이러스 놓고
	// 몇초 걸리는지 구하는 메서드
	static int infection(int[] s){
		//System.out.print("virus search 시작 :");
		int[][] m = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				m[i][j]=virus[i][j];
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int x = vPoint[s[i]][0];
			int y = vPoint[s[i]][1];
			q.add(new Point(x,y));
			m[x][y]=1;
			//System.out.print("x,y:"+x+","+y+" ");
		}
		//System.out.println("");
		while(!q.isEmpty()){
			
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				
				if(x>=0 && x<N && y>=0 && y<N && m[x][y]==0){
					m[x][y]=m[p.x][p.y]+1;
					q.add(new Point(x,y));
				}
			}
		}
		int max = 0;
		
		for (int i = 0; i < vPossible; i++) {
			m[vPoint[i][0]][vPoint[i][1]]=1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//System.out.print(m[i][j]+" ");
				if(max<m[i][j])max = m[i][j];
				if(m[i][j]==0)return -1;
			}
			//System.out.println("");
		}
		return max-1;
	}
	
	// 좌표 객체
	static class Point {
		
		int x ;
		int y ;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

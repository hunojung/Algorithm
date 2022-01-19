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
	//static int test = 0;

	static int[][] map;
	static int N,M;
	static ArrayList<Point> arr = new ArrayList<>();
	
	static int result = Integer.MAX_VALUE;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	// 0인곳 갯수- 바이러스 놓을 수 있는 자리는 생각 안함 
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		count = N*N;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				
				// 바이러스 가능 위치 저장
				// 0 으로 초기화
				if(map[i][j]==2){
					arr.add(new Point(i,j));
					count--;
				}
				
				// 총 감염해야 되는 수는 N*N - 벽갯수
				// -1로 변경
				if(map[i][j]==1){
					count--;
				}
			}
		}
		
		if(count==0){
			System.out.println(0);
		}else{
			dfs(0,0);
			result = result==Integer.MAX_VALUE?-1:result;
			System.out.println(result);
		}
		
		//System.out.println("test count :"+test);
		br.close();
		System.exit(0);
	}
	
	// 바이러스 시작위치 받아서 몇초걸리는지 받는 메서드
	static void dfs(int depth, int start){
		if(depth == M){
			//test++;
			bfs();
			return;
		}else{

			// depth가 0 이면 마지막 배열까지 돌리는게 아니고
			// 5개중에 3개 선택이면 마지막 2개는 선택 안되도록 해야함
			for (int i = start; i < arr.size(); i++) {
				Point p = arr.get(i);
				
				if(map[p.x][p.y]==3)continue;
				map[p.x][p.y] = 3;
				//System.out.println("depth :"+depth+" /"+p.x+" "+p.y+" 3변환 ,"+(M+depth+1));
				dfs(depth+1,i+1);
				map[p.x][p.y] = 2;
			}
		}
	}
	
	
	// 바이러스 몇초 걸리는지 구하는 메서드
	static void bfs(){
		int[][] virus = new int[N][N];
		Queue<Point> q = new LinkedList<>();
		
		// 감염 시킨 수 센다
		int cnt = 0 ;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if(map[i][j]==3){
					virus[i][j]=1;
					q.add(new Point(i,j));
				}
			}
		}
		while(!q.isEmpty()){
			
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				
				if(x>=0 && x<N && y>=0 && y<N){
					
					// 벽이 아니면서 안 들린 곳
					if(map[x][y]!=1 && virus[x][y]==0){
						virus[x][y]=virus[p.x][p.y]+1;
						q.add(new Point(x,y));
						
						//0이곳 감염 시킨 갯수
						if(map[x][y]==0){
							cnt++;							
						}
						
						//마지막에 감염 시키면
						if(cnt == count){
							result = Math.min(result, virus[x][y]-1);
						}
					}
				}
			}
		}

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

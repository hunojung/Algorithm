// https://www.acmicpc.net/problem/21610
// 마법사 상어와 비바라기

// 분류
// 구현
// 시뮬레이션
import java.io.*;
import java.util.*;

public class Main{
	static int[][] map; // 바구니 물  저장
	static int[][] move; // 구름이 움직일 방향 및 거리 저장
	static int[][] cloud; // 구름이 생긴 위치
	static int[][] movedCloud; // 구름이 생기고 사라진 자리 기억
	
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 }; // 방향 1~8
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 방향 1~8
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer	st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		cloud = new int[N+1][N+1];
		movedCloud = new int[N+1][N+1];
		move = new int[M][2];
		
		cloud[N][1] = 1;
		cloud[N][2] = 1;
		cloud[N-1][1] = 1;
		cloud[N-1][2] = 1;
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 구름 방향 및 거리
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			move[i][0]=Integer.parseInt(st.nextToken());
			move[i][1]=Integer.parseInt(st.nextToken());
		}
		
		rain();
		
		int ans = 0;
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				ans+=map[i][j];
				//System.out.print(map[i][j]+" ");
			}
			//System.out.println("");
		}
		
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
	
	static void rain(){
		
		// 구름이 먼저 한번 움직임
		
		for (int i = 0; i < M; i++) {
			
			cloud_moveAndRemove_add(i);
			cloud_make();
		}
	}
	
	// 비온 후 구름 만들기
	static void cloud_make(){
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(movedCloud[i][j]==1){
					movedCloud[i][j]=0;
				}else{
					if(map[i][j]>1){
						cloud[i][j]=1;
						map[i][j]-=2;
					}
				}
			}
		}
	}
	
	static void cloud_moveAndRemove_add(int count){
		
		// 구름이 이동할 방향(1~8)move[count][0] 및 거리move[count][1]
		int x = dx[move[count][0]-1]*move[count][1];
		int y = dy[move[count][0]-1]*move[count][1];
		// 물복사 마법 쓰기위한 대각선 위치
		int[][] waterCopy = {{-1,1},{1,1},{1,-1},{-1,-1}};
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(cloud[i][j]==1){
					
					// 현재 i,j에서 이동량 더하기
					int x2 = (x+i);
					int y2 = (y+j);

					//System.out.println("단순  더하기 : "+x2+" "+y2);
					while(x2>N || x2<1){
						if(x2<1){
							x2+=N;
						}else{
							x2-=N;
						}
					}
					while(y2>N || y2<1){
						if(y2<1){
							y2+=N;
						}else{
							y2-=N;
						}
					}
					//System.out.println("이동 후 구름 : "+x2+" "+y2);
					
					movedCloud[x2][y2]=1;
					cloud[i][j]=0;
					map[x2][y2]++;
				}
			}
		}
		//if(count==0)return;
		// 물복사 마법 시전
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(movedCloud[i][j]==1){
					int crossCount = 0;
					for (int k = 0; k < 4; k++) {
						x = i+waterCopy[k][0];
						y = j+waterCopy[k][1];
						
						// 대각선 갯수 세기
						if(x>0 && x<N+1 && y>0 && y<N+1){
							if(map[x][y]>0){
								crossCount++;
							}
						}
					}
					
					// 대각선에 0이상인것 갯수만큼 +
					map[i][j]+=crossCount;
				}
			}
		}
		
	}
}

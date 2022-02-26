// https://www.acmicpc.net/problem/14499
// 주사위 굴리기
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		// . 2 .
		// 4 1 3
		// . 5 .
		// . 6 .
		int[][] dice = new int[4][3];
		int[] pos = new int[2];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pos[0] = Integer.parseInt(st.nextToken());
		pos[1] = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int move = Integer.parseInt(st.nextToken());
			if(moveDice(map,dice,pos,move))
				sb.append(dice[1][1]+"\n");
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static boolean moveDice(int[][] map,int[][] dice,int[] pos,int move){
		boolean moved = false;
		if(move==1 && pos[1]<map[0].length-1){
			pos[1]++;
			moved = true;
			
			int tmp = dice[1][2];
			dice[1][2]=dice[1][1];
			dice[1][1]=dice[1][0];
			dice[1][0]=dice[3][1];
			dice[3][1]=tmp;
				
		}else if(move==2 && pos[1]>0){
			pos[1]--;
			moved = true;
			
			int tmp = dice[1][0];
			dice[1][0]=dice[1][1];
			dice[1][1]=dice[1][2];
			dice[1][2]=dice[3][1];
			dice[3][1]=tmp;
			
		}else if(move==3 && pos[0]>0){
			pos[0]--;
			moved = true;
			
			int tmp = dice[0][1];
			for (int i = 0; i < 3; i++) {
				dice[i][1]=dice[i+1][1];
			}
			dice[3][1]=tmp;
		}else if(move==4 && pos[0]<map.length-1){
			pos[0]++;
			moved = true;
			
			int tmp = dice[3][1];
			for (int i = 3; i > 0; i--) {
				dice[i][1]=dice[i-1][1];
			}
			dice[0][1]=tmp;
		}
		
		if(!moved)return moved;
		
		if(map[pos[0]][pos[1]]==0){
			map[pos[0]][pos[1]] = dice[3][1];
		}else{
			dice[3][1]=map[pos[0]][pos[1]];
			map[pos[0]][pos[1]]=0;
		}
		return moved;
	}
}

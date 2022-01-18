// https://www.acmicpc.net/problem/12759
// 틱! 택! 토!

// 분류
// 구현
// 시뮬레이션
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[3][3];
		int[][] B = new int[3][3];
		int winner = 0;
		for (int i = 0; i < 9; i++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			if(N==2){
				B[a][b]=1;
				winner = win(B)?N:0;
				N--;
			}else{
				A[a][b]=1;
				winner = win(A)?N:0;
				N++;
			}
			
			if(winner != 0)break;
		}
		
		System.out.println(winner);
		br.close();
		System.exit(0);
	}
	
	static boolean win(int[][] player){
		int cross1 = 0;
		int cross2 = 0;
		
		for (int i = 0; i < 3; i++) {
			int countRow = 0;
			int countCol = 0;
			
			for (int j = 0; j < 3; j++) {
				if(player[i][j]==1)countCol++;
				if(player[j][i]==1)countRow++;
			}

			if(player[i][2-i]==1)cross1++;
			if(player[i][i]==1)cross2++;
			
			if(countCol == 3 || countRow == 3 || cross1 == 3 || cross2 == 3){
				return true;
			}
		}
		
		return false;
	}
}

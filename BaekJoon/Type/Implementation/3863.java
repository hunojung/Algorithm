// https://www.acmicpc.net/problem/3863
// 행복한 전화 통화

// 분류
// 구현
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N==0 && M==0)break;
			
			int[][] call = new int[N][2];
			int[][] police = new int[M][2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				call[i][0]=c;
				call[i][1]=c+d;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				police[i][0]=a;
				police[i][1]=a+b;
			}
			//System.out.println("ok"+" "+N+" "+M);
			for (int i = 0; i < M; i++) {
				int answer = 0;
				for (int j = 0; j < N; j++) {
					//System.out.println(i+" "+j);
					
					if((call[j][0]>police[i][0] && call[j][0]<police[i][1])
							|| (call[j][1]>police[i][0] && call[j][0]<police[i][1])){
						answer++;
					}
				}
				sb.append(answer).append("\n");
			}
			
		}
		System.out.println(sb);
		
		br.close();
		//input.close();
		System.exit(0);
	}
}

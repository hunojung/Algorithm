// https://www.acmicpc.net/problem/10830
// 행렬 제곱
import java.io.*;
import java.util.*;

// 80% 예외
//2 1
//1000 1000
//1000 1000
//
//정답
//0 0
//0 0
public class Main {
	static int[][] A,answer;
	static int N;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken()); 
		A = new int[N][N];
		answer = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				answer[i][j]=A[i][j]%1000;
			}
		}
		
		divideAndConquer(B-1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]+" ");
			}sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	static void divideAndConquer(long B){
		if(B==0)return;
		
		long n = 1;
		int[][] sumArr = new int[N][N];
		int[][] addArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sumArr[i][j]=A[i][j];
			}
		}
		// B = 1 / n = 1
		// B = 2 / n = 2
		// B = 3 / n = 2
		// B = 4 / n = 4
		// B = 7 / n = 4
		
		while((n*2)<=B){
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = 0;
					for (int k = 0; k < N; k++) {
						sum+=(sumArr[i][k]*sumArr[k][j])%1000;
					}
					addArr[i][j]=sum%1000;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sumArr[i][j]=addArr[i][j];
				}
			}
			n*=2;
		}
		
		// answer에 합체
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int k = 0; k < N; k++) {
					sum+=(answer[i][k]*sumArr[k][j])%1000;
				}
				addArr[i][j]=sum%1000;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer[i][j]=addArr[i][j];
			}
		}
		divideAndConquer(B-n);
	}
}

// https://www.acmicpc.net/problem/19951
// 태상이의 훈련소 생활

// 분류
// 누적 합
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] soil = new int[N];
		int[] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			soil[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			sum[a]+=k;
			sum[b]-=k;
		}
		
		int add = 0;
		for (int i = 0; i < N; i++) {
			add += sum[i];
			System.out.print((soil[i]+add)+" ");
		}
		
		br.close();
		System.exit(0);
	}
}

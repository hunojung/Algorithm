// https://www.acmicpc.net/problem/17425
// 약수의 합

// 분류
// 수학
// 정수론
// 누적 합
// 소수 판정
// 에라토스테네스의 체
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		long[] f = new long[1000001];
		long[] g = new long[1000001];
		for (int i = 1; i < 1000001; i++) {
			for (int j = 1; i*j < 1000001; j++) {
				f[i*j]+=i;
			}
		}
		for (int i = 1; i < 1000001; i++) {
			g[i]=g[i-1]+f[i];
		}
		
		// 테스트 케이스에 대한 효율성을 향상시켜 해결
		while(testcase-->0){
			int N = Integer.parseInt(br.readLine());
			sb.append(g[N]+"\n");
		}
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}

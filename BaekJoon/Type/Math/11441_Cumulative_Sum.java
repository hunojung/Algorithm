// https://www.acmicpc.net/problem/11441
// 합 구하기

// 분류
// 누적 합
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
		}
		
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-->0){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			sb.append(arr[e]-arr[s-1]+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

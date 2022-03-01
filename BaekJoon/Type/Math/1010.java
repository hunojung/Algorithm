// https://www.acmicpc.net/problem/1010
// 다리 놓기
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int answer = 1;
			// 
			for (int i = 1; i < N+1; i++) {
				answer*=(M-(i-1));
				answer/=i;
			}
			
			sb.append(answer+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

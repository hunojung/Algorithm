// https://www.acmicpc.net/problem/11021
// A+B - 7

// 분류
// 수학
// 구현
// 사칙연산
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
        int N = Integer.parseInt(br.readLine());
		
        for (int i = 1; i < N+1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
			sb.append("Case #"+i+": "+(a+b)+"\n");
		}
        // 출력
        System.out.println(sb);
        br.close();
		System.exit(0);
	}
}

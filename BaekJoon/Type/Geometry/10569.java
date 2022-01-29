// https://www.acmicpc.net/problem/10569
// 다면체

// 분류
// 수학
// 기하학
// 사칙연산
// 오일러 지표 (χ=v-e+f)
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			sb.append(2-V+E).append("\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

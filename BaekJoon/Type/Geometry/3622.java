// https://www.acmicpc.net/problem/3622
// 어떤 호박의 할로윈 여행

// 분류
// 기하학
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String answer ="No";
		
		// P >= A , a >= B
		if(P>=A && a>=B){
			answer = "Yes";
		}
		
		// P >= B, b >= A
		if(P>=B && b>=A){
			answer = "Yes";
		}
		
		// P >= A + B 
		if(P>=(A+B)){
			answer = "Yes";
		}
		
		System.out.println(answer);
	}
}

// https://www.acmicpc.net/problem/1629
// 곱셈

// 분류
// 수학
// 분할 정복을 이용한 거듭제곱
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		System.out.println(pow(A,B,C));
		
		br.close();
		System.exit(0);
	}
	
	static long pow(long A, long B, long C){

		if(B == 1)
			return A%C;
		
		long temp = pow(A,B/2,C);
				
		if(B%2==1)
			return (temp*temp%C*A)%C;			
		return temp*temp%C;
	}
}

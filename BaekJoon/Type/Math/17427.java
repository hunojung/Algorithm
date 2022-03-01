// https://www.acmicpc.net/problem/17427
// 약수의 합2
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		
		// 1~N 사이에 i를 약수로 갖는 숫자는?
		// 그 숫자의 갯수만큼 i를 더해주면 된다
		for (int i = 1; i < N+1; i++) {
			sum+=(N/i)*i;
		}
		System.out.println(sum);
		
		br.close();
		System.exit(0);
	}
}

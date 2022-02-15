// https://www.acmicpc.net/problem/15740
// A+B - 9
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int min = Integer.MAX_VALUE, count = 1;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		System.out.println(a.add(b));
		br.close();
		System.exit(0);
	}
}

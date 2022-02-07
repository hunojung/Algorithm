// https://www.acmicpc.net/problem/2407
// 조합
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger N = new BigInteger(st.nextToken());
		BigInteger M = new BigInteger(st.nextToken());
		int m = Integer.parseInt(M.toString());
		BigInteger bi = new BigInteger("1");
		for (int i = 0; i < m; i++) {
			bi = bi.multiply(N);
			N = N.add(new BigInteger("-1"));
		}
		for (int i = 0; i < m; i++) {
			bi = bi.divide(M);
			M = M.add(new BigInteger("-1"));
		}
		
		System.out.println(bi);
		
		br.close();
		System.exit(0);
	}
}

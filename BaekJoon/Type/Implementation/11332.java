// https://www.acmicpc.net/problem/11332
// 시간초과

// long으로 선언할 경우 N=1000000 , T=10일때 오류 발생

// 분류
// 구현
// 많은 조건 분기
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String n = st.nextToken();
			BigInteger N = new BigInteger(n);
			BigInteger T = new BigInteger(st.nextToken());
			BigInteger L = new BigInteger(st.nextToken()).multiply(new BigInteger("100000000"));
			
			String ans = "May Pass.";
			
			// long으로 선언할 경우 N=1000000 , T=10일때 오류 발생
			//System.out.println(N*N*N*T);
			
			//1
			if(s.equals("O(N)")){
				if(N.multiply(T).compareTo(L)==1){
					ans="TLE!";
				}
			
			//2
			}else if(s.equals("O(N^2)")){
				if(N.pow(2).multiply(T).compareTo(L)==1){
					ans="TLE!";
				}
			
			//3
			}else if(s.equals("O(N^3)")){
				if(N.pow(3).multiply(T).compareTo(L)==1){
					ans="TLE!";
				}
			
			//4
			}else if(s.equals("O(2^N)")){
				BigInteger two = new BigInteger("2");
				
				if(two.pow(Integer.parseInt(n)).multiply(T).compareTo(L)==1){
						ans="TLE!";
				}
			
			//5
			}else{
				int fac = Integer.parseInt(n);
				N=N.multiply(T);
				while(fac-->1){
					N = N.multiply(new BigInteger(Integer.toString(fac)));
					if(N.compareTo(L)==1){
					ans="TLE!";
						break;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}

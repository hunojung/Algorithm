// 피보나치 수 2
// https://www.acmicpc.net/problem/2748
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] fibonacci = new long[n+1];
		
		if(n<2) {
			System.out.println(n);
		} else {
			fibonacci[1]=1;
			for (int i = 2; i < n+1; i++) {
				fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
			}
			
			System.out.println(fibonacci[n]);
		}
		
		//System.out.println(fib(fibonacci,n));
		
		br.close();
		System.exit(0);
	}
	
	static long fib(long[] fibonacci,int n) {
		if(n<2) return n;
		
		if(fibonacci[n]>0) return fibonacci[n];
		
		return fibonacci[n]=fib(fibonacci,n-1)+fib(fibonacci,n-2);
	}
}

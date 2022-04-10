// 피보나치 수 3
// https://www.acmicpc.net/problem/2749
import java.io.*;
import java.util.*;

/*
n
=(n-1)+(n-2)
=(n-2)+(n-3)+(n-2)=2(n-2)+(n-3)
=2((n-3)+(n-4))+(n-3)=3(n-3)+2(n-4)
=3((n-4)+(n-5))+2(n-4)=5(n-4)+3(n-5)
=8(n-5)+5(n-6)
=13(n-6)+8(n-7)

n=10
f6*f5+f5*f4 = f5(f5+2*f4);
n=9
f5*f5+f4*f4
n=8
f5*f4+f4*f3
*/
public class Main {
	static Map<Long,Long> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		map.put(0l,0l);
		map.put(1l,1l);
		map.put(2l,1l);
		map.put(3l,2l);
		map.put(4l,3l);
		map.put(5l,5l);
		System.out.println(fib(n));
		
		br.close();
		System.exit(0);
	}
	
	static long fib(long n) {
		if(map.containsKey(n)) return map.get(n);
		
		if(n%2==0) {
			long a = fib(n/2);
			long b = fib(n/2-1);
			
			map.put(n,(a*((a+(2*b))))%1000000);
		} else {
			long a = fib(n/2+1);
			long b = fib(n/2);

			map.put(n,((a*a)+(b*b))%1000000);
		}
		
		return map.get(n);
	}
}

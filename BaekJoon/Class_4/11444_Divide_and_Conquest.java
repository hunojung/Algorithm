// https://www.acmicpc.net/problem/11444
// 피보나치 6
import java.io.*;
import java.util.*;

public class Main {
	static long[] nums = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597};
	static Map<Long,Long> map;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long N = Long.parseLong(br.readLine());
		map = new HashMap<>();
		// f(2) = f(1) + f(0)
		// f(3) = 2f(1) + f(n-3)
		// f(4) = 3f(1) + 2f(n-4)
		// f(5) = 5f(1) + 3f(n-5)
		// f(6) = 8f(1) + 5f(n-6)
		// f(7) = 13f(1) + 8f(n-7)
		// ...
		// f(n) = f(n-1)*f(1)
		
		// f(n) = f(n-1) + f(n-2)
		// f(n) = 2f(n-2) + f(n-3)
		// f(n) = 3f(n-3) + 2f(n-4)
		// f(n) = 5f(n-4) + 3f(n-5)
		// f(n) = 8f(n-5) + 5f(n-6)
		// f(n) = 13f(n-6) + 8f(n-7) = f(7)f(n-6) + f(6)f(n-7)
		// ...
		// f(13) = f(7)f(7)+f(6)f(6)
		// f(14) = f(7)f(8)+f(6)f(7) = f(8)f(7)+f(7)f(6);
		
		System.out.println(f(N));
		
		br.close();
		System.exit(0);
	}
	
	static long f(long N){
		if(N<18)return nums[(int)N];
		
		if(!map.containsKey(N)){
			if(N%2==0){
				map.put(N, ((f(N/2+1)+f(N/2-1))*f(N/2))%1000000007);
			}else{
				long n1 = f(N/2+1);
				long n2 = f(N/2);
				map.put(N, (n1*n1+n2*n2)%1000000007);
			}
		}
		return map.get(N);
	}
}

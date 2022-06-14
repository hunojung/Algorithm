// 소수의 연속합
// https://www.acmicpc.net/problem/1644
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		boolean[] prime = new boolean[num+1];
		
		for(int i=2;i<=num;i++) {
			if(prime[i]) continue;
			if(isPrime(i)) {
				list.add(i);
			}
            
            for (int j = i*2; j <= num; j+=i) {
                prime[j]=true;
            }
		}

		int[] sum = new int[list.size()+1];
		for(int i=0;i<list.size();i++) {
			sum[i+1] = sum[i]+list.get(i);
		}
		
		int l=0,r=1;
		int answer = 0;
		while(l<r && r<sum.length) {
			if(sum[r]-sum[l]==num){
				answer++;
				r++;
			}else if(sum[r]-sum[l]>num) {
				l++;
			}else {
				r++;
			}
		}
		
		System.out.println(answer);

		br.close();
		System.exit(0);
	}
	
	static boolean isPrime(int n) {
		if(n==0 || n==1 || n==2) return true;
		
		if(n%2==0) return false;
		
		for(int i=3;i*i<=n;i+=2) {
			if(n%i==0) return false;
		}
		
		return true;
	}
}

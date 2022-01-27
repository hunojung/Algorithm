// https://www.acmicpc.net/problem/2661
// 좋은 수열

// 분류
// 백트래킹
import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static String answer;
	static String[] numbers = {"1","2","3"};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String num="1";
		dfs("1",num);
		br.close();
		System.exit(0);
	}
	
	static boolean confirm(String s){
		int len = s.length();
		
		for (int i = 1; i < s.length()/2+1; i++) {
			String sub = s.substring(len-i,len);
			if(s.contains(sub+sub))return false;
		}
		return true;
	}
	
	static void dfs(String last,String sum){
		if(!confirm(sum))
			return;

		if(sum.length()==N){
			System.out.println(sum);
			System.exit(0);
		}
		
		for (int i = 0; i < 3; i++) {
			if(!numbers[i].equals(last)){
				dfs(numbers[i],sum+numbers[i]);
			}
		}
	}
}

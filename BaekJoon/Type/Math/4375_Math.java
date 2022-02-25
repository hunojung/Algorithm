// https://www.acmicpc.net/problem/4375
// 1
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		// 입력
		while((s = br.readLine())!=null && !s.equals("")){
			int n = Integer.parseInt(s);
			sb.append(divide(n)+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static int divide(int n){
		int tmp = 0;
		for (int i = 1; i <= n; i++) {
			tmp = (tmp*10+1)%n;
			if(tmp==0)
				return i;
		}
		
		return -1;
	}
}

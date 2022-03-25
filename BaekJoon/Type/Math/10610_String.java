// https://www.acmicpc.net/problem/10610
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		Arrays.sort(s);

		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=s.length-1;i>-1;i--) {
			sum+=s[i]-'0';
			sb.append(s[i]);
		}
		
		if(sum%3==0 && s[0]=='0') System.out.println(sb);
		else System.out.println(-1);
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/problem/10799
// 쇠 막대기

// 분류
// 자료 구조
// 스택
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int count = 0;
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			char next = s.charAt(i);
			
			if(next=='('){
				count++;
			}else{
				count--;
				if(s.charAt(i-1)=='('){
					answer+=count;
				}else{
					answer++;
				}
			}
		}
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}

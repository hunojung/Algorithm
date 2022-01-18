// https://www.acmicpc.net/problem/12904
// A와 B

// 분류
// 구현
// 문자열
// 그리디 알고리즘
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		String S = br.readLine();
		String T = br.readLine();
		
		int lenS = S.length();
		int lenT = T.length();
		
		int answer = 0;
		for (int i = 0; i < lenT-lenS; i++) {
			if(T.charAt(T.length()-1)=='B'){
				T = T.substring(0,T.length()-1);
				T = new StringBuilder(T).reverse().toString();
			}else{
				T = T.substring(0,T.length()-1);
			}
			//System.out.println(T);
		}
		if(T.equals(S))answer=1;
		System.out.println(answer);
		
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/problem/23885
// 비숍 투어

// 분류
// 애드 혹
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		
		boolean even = false;
		boolean ans = false;
		if((x1+y1)%2 == 0){
			even = true;
		}
		
		if((x2+y2)%2 == 0){
			ans = true;
		}
		
		String answer = "NO";
		if(x1==x2 && y1==y2){
			answer="YES";
		}else if(even==ans&& N!=1 && M !=1){
			answer="YES";
		}

		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}

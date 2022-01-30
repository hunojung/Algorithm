// https://www.acmicpc.net/problem/1110
// 더하기 사이클

// 분류
// 수학
// 구현
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int now = N;
		int next = 0;
		int answer = 0;
		while(true){
			next = now/10 + now%10;
			now = (now%10)*10 + next%10;
			answer++;
			if(now==N)break;
		}
        System.out.println(answer);
		System.exit(0);
	}
}

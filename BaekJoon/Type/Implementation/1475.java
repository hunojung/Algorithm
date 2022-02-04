// https://www.acmicpc.net/problem/1475
// 방번호
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10];
		while(N>0){
			count[N%10]++;
			N/=10;
		}
		int answer=0;
		count[6]=(count[6]+count[9])%2==0?(count[6]+count[9])/2:(count[6]+count[9])/2+1;
		for (int i = 0; i < 9; i++) {
			if(answer<count[i]){
				answer=count[i];
			}				
		}
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}

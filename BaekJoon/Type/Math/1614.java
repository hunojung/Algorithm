// https://www.acmicpc.net/problem/1614
// 영식이의 손가락

// 분류
// 수학
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int test = 10000;
		long hand = Long.parseLong(br.readLine());
		long N = Long.parseLong(br.readLine());
		long ans = 0;
		
		if(hand==1 || hand==5){
			
			ans = hand+N*8-1;
			
		}else if(hand == 3){
			
			ans = hand+N*4-1;
			
		}else if(hand == 2){
			
			if(N%2==0){
				ans = N*4+1;
			}else{
				ans = (N+1)*4-1;
			}
			
		}else{
			if(N%2==0){
				ans = (N+1)*4-1;
			}else{
				ans = N*4+1;
			}
		}
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
}

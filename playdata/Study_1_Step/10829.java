// 이진수 변환
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 값 입력 
		Long N = Long.parseLong(br.readLine());
		
		if(N==0){
			System.out.println(0);
			System.exit(0);
		}
		String ans ="";
		while(N>0){
			
			ans = Long.toString(N%2)+ans;
			
			N/=2;
		}
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
}

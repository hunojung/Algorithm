// 팩토리얼
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 값 입력 
		int N = Integer.parseInt(br.readLine());

		System.out.println(fact(N));
		
		br.close();
		System.exit(0);
	}
	
	static int fact(int N){
		if(N == 0 || N == 1) return 1;
		else if( N == 2) return 2;
		else return N * fact(N-1);
	}
}

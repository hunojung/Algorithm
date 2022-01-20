// 2×n 타일링
// 11726
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] square;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		
		// 2 - 2
		// 3 - 3
		// 4 - 5
		// 5 - 8
		// 6 - 13
		// 7 - 
		square = new int[N+1];
		square[1] = 1;
		if(N>1)square[2] = 2;
		if(N>2)square[3] = 3;
		
		int number = dp(N);
		
		System.out.println(number);
		
		br.close();
		System.exit(0);
	}
	
	static int dp(int N){
		if(square[N] != 0){
			return square[N];
		}else {
			
			square[N] = (dp(N-1)+dp(N-2))%10007;
			return square[N];
		}
	}
}
// 11726 END

// *2 하나 차이!!
	
// 2×n 타일링2
// 11727
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] square;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
	
		// 1 - 1
		// 2 - 3
		// 3 - 5
		// 4 - 11
		// 5 - 21
		// 6 - 63
		// 7 - 85
		square = new int[N+1];
		square[1] = 1;
		if(N>1)square[2] = 3;
		if(N>2)square[3] = 5;
		
		int number = dp(N);
		
		System.out.println(number);
		
		br.close();
		System.exit(0);
	}
	
	static int dp(int N){
		if(square[N] != 0){
			return square[N];
		}else {
			square[N] = (dp(N-1)+dp(N-2)*2)%10007;
			return square[N];
		}
	}
}
// 11727

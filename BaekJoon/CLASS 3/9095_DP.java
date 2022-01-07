// 1, 2, 3 더하기
// 9095
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	static boolean[] ok; 
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		// 1 (1)	: 1
		// 2 (2)	: 11 / 2
		// 3 (4)	: 111 / 12 - 2 / 3
		// 4 (7)	: 1111 / 112 - 3 / 22 / 13 -2
		// 5 (13)	: 11111 / 1112 - 4 / 122 - 3 / 113 -3 / 23 -2 
		// 6 (24)	: 111111 / 11112 -5 / 1122 - 6  / 222 / 1113 - 4 / 123 - 6/ 33
		while(testcase-->0){
			int number = Integer.parseInt(br.readLine());		
			sb.append(dp(number)).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	public static int dp(int number){
		
		if(number == 1)return 1;
		else if(number == 2)return 2;
		else if(number == 3)return 4;
		else if(number == 4)return 7;
		else return dp(number-1)+dp(number-2)+dp(number-3);
  }
}
// 9095 END

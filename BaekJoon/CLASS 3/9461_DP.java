// 파도반 수열
// 9461
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	static Long[] P = new Long[100];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		int[] p = {1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
		for (int i = 0; i < 10; i++) {
			P[i]=(long)p[i];
		}
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			int number = Integer.parseInt(br.readLine());
			sb.append(dp(number-1)).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	public static Long dp(int num){
		//System.out.println(num);
    
		if(P[num]==null){
			P[num]=dp(num-1)+dp(num-5);
		}
		
		return P[num];
	}
}
// 9461 END

// Four Square
// 17626
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] num = new int[50001]; 
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		num[1]=1;
		num[2]=2;
		num[3]=3;
		
		System.out.println(dp(N));
		br.close();
		System.exit(0);
	}
	/*
	 * 1 - 1(1)
	 * 2 - 2(1,1)
	 * 3 - 3(1,1,1)
	 * 4 - 1(2)
	 * 5 - 2(2,1)
	 * 6 - 3(2,1,1)
	 * 7 - 4(2,1,1,1)
	 * 8 - 2(2,2)
	 * 9 - 1(3)
	 * 10 - 2(3,1)
	 * 11 - 3(3,1,1)
	 * 12 - 3(2,2,2)
	 * 13 - 2(3,2)
	 * 14 - 3(3,2,1)
	 * 15 - 4(3,2,1,1)
	 * 16 - 1(4)
	 * 17 - 2(4,1)
	 * 18 - 2(3,3)
	 * 19 - 3(3,3,1)
	 * 20 - 2(4,2)
	 */
	static int dp(int N){
		
		// 값이 없으면 입력
		if(num[N]==0){
			int n = (int)Math.sqrt(N);
			
			// 그 자체가 제곱수면 1
			if(N==(n*n)){
				num[N]=1;
			
			// 아니면 일단 1개 넣고 while문 돌면서 최솟값
			}else{
				num[N]=dp(n*n)+dp(N-n*n);
				
				// n*n이 N-n*n보다 작아지면 의미 없다
				while(n*n > N-n*n){
					n--;
					num[N]=Math.min(num[N], dp(n*n)+dp(N-n*n));
				}
			}
		}
		return num[N];
	}
}
// 17626 END

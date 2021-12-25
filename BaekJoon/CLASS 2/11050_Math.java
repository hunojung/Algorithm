// 이항계수 1
// 11050
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		if(N==K || K==0){
			ans=1;
		}else if(K > 0 && N > K){
			ans = fact(N)/(fact(K)*fact(N-K));
		}
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
	
	public static int fact(int n){
		if(n <= 1){
			return n;
		}else{
			return fact(n-1)*n;
		}
	}
}
// 11050 END

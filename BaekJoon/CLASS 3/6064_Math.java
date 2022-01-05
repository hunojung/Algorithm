// 카잉 달력
// 6064
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 최대 공배수
			int number = (M*N)/gcd(M,N);
			
			while(x<=number){
				if(N==1){
					break;
				}
				if((x%N==0?N:x%N)==y){
					break;
				}
				x+=M;
			}
			
			if(x>number){
				sb.append(-1).append("\n");
			}else{
				sb.append(x).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	// 최대공약수 반복문 방식
	public static int gcd(int a, int b) {
	 
		while (b != 0) {
			int r = a % b; // 나머지를 구해준다.
	 
			// GCD(a, b) = GCD(b, r)이므로 변환한다.
			a = b;
			b = r;
		}
		return a;
	}
}
// 6064 END

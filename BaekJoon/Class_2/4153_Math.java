// 직각 삼각형
// 4153
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());
			long C = Integer.parseInt(st.nextToken());
			String ans = "wrong";
			
			if( A*B*C > 0){
				long a=A*A;
				long b=B*B;
				long c=C*C;
				//System.out.println(a+" "+b+" "+c);
				if(a == b+c || b == a+c || c == a+b) ans = "right";
			}else{
				break;
			}
			System.out.println(ans);
		}
		
		br.close();
		System.exit(0);
	}
}
// 4153 END

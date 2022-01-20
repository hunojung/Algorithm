// 소수 찾기
// 1929
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean sosu = true;
		
		while(M <= N){
			
			sosu = true;
			if(M > 2)
				for (int i = 2; i < Math.sqrt(M)+1; i++) {
					if(i>2 && i%2==0)i++;
					if(M%i == 0){
						sosu = false;
						break;
					}
				}
			
			// 1 제외 안했더니 오답 발생
			if(sosu && M!=1)System.out.println(M);
			M++;
		}
		br.close();
		System.exit(0);
	}
}
// 1929 END

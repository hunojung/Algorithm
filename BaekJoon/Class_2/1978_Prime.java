// 소수 찾기
// 1978
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numbers;
		int count = 0;
		
		for (int i = 0; i < testcase; i++) {	
			boolean sosu = true;
			numbers = Integer.parseInt(st.nextToken());
			
			if(numbers == 1){
				continue;
			}else{
				if(numbers == 2){
					count++;
					continue;
				}
				
				for (int j = 2 ; j < Math.sqrt(numbers)+1; j++){
					if(numbers%j==0){
						sosu = false;
						break;
					}
					if(j%2!=0)j++;
				}
			}
			if(sosu == true)count++;
		}
		
		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
}
// 1978

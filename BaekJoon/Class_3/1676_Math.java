// 팩토리얼 0의 개수
// 1676
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		
		int number = Integer.parseInt(br.readLine());
		
		int mul = 1;
		int count = 0;
		for (int i = 1; i < number+1; i++) {
			mul=i;
			while(mul%5==0){
				count++;
				mul/=5;	
			}
		}
		
		System.out.println(count);
		br.close();
		System.exit(0);
	}
}
// 1676 END

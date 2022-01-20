// 피보나치 함수
// 1103
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			int a = 0;
			int c = 1;
			int before_c = 1;
			int number = Integer.parseInt(br.readLine());
			
			if ( number == 0){
				System.out.println(1+" "+0);
			}else if( number == 1){
				System.out.println(0+" "+1);
			}else{
				for (int i = 1; i < number; i++) {
					before_c=c;
					c = a + c;
					a = before_c;
				}
				System.out.println(a+" "+c);				
			}
		}

		br.close();
		System.exit(0);
	}
}
// 1103 END

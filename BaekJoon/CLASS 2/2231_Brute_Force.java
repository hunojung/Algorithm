// 분해합
// 2231
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		int testNumber = 0;
		int test;
		int ans = number+1;
		while(testNumber < number ){
			
			ans = testNumber;
			test = testNumber;
			
			while(test>0){
				ans += test%10;
				test /= 10;
			}
			
			if(number == ans)break;
			testNumber +=1;
		}
		
		if(testNumber == number)testNumber=0;
		System.out.println(testNumber);
		
		br.close();
		System.exit(0);
	}
}

// 2231 END

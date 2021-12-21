// 통계학
// 2108
package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class beakjon_test {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[testcase];
		int sum = 0;
		
		for (int i = 0; i < testcase; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
		}
		
		Arrays.sort(numbers);
		
		int count=0;
		int maxcount=0;
		int number = numbers[0];
		int minnumber = numbers[0];
		int min2number = numbers[0];
		
		for (int i = 0; i < numbers.length; i++) {
			
			if(number == numbers[i]){
				count++;
			}else{
				number = numbers[i];
				count = 1;
			}
			
			if(count > maxcount){
				
				minnumber=number;
				min2number=number;
				maxcount=count;
				
			}else if(count == maxcount){
				
				if(min2number == minnumber) min2number = number;
				
			}
		}
		// 평균
		System.out.println(Math.round((double)sum/testcase));
		// 중앙값
		System.out.println(numbers[testcase/2]);
		// 최빈값
		System.out.println(min2number);
		// 범위
		
		System.out.println(numbers[testcase-1]-numbers[0]);
		
		br.close();
		System.exit(0);
	}
}
// 2108 END

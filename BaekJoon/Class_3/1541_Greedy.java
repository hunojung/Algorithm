// 잃어버린 괄호
// 1541
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		
		String str = br.readLine();
		int sum=0;
		int number=0;
		int minussum=0;
		boolean status = true; // true 면 + 상태
		for (int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i)=='+'){
				// + 상태에서 +로 됨 
				// +하고 넘버 초기화
				if(status){
					sum+=number;
					number=0;					
				// 한번 - 상태에서 +로 됨
				// 계속 숫자를 누적
				}else{
					minussum+=number;
					number=0;
				}
			}else if(str.charAt(i)=='-'){
				// - 상태에서 - 됨
				// - 누적된거 - 하고 초기화
				// - 하고 넘버 초기화
				if(!status){
					sum-=minussum;
					sum-=number;
					minussum=0;
					number=0;
				
				// + 상태에서 - 됨
				}else{
					sum+=number;
					number=0;
					status=false;
				}
			// 숫자 누적
			}else{
				number=number*10+Integer.parseInt(str.charAt(i)+"");
			}
		}
		
    // 마지막 숫자 연산
		if(status){
			sum+=number;
		}else{
			sum-=minussum;
			sum-=number;
		}
		
		System.out.println(sum);
		
		
		br.close();
		System.exit(0);
	}
}
// 1541 END

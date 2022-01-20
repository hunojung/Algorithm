// 설탕 배달
// 2839
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		int count = 0;
        
		// 3, 5의 최소 공배수 15 이상이면 5로 다 바꿈
		if(number>=15){
			count+=(number-10-number%5)/5;
			number=10+number%5;
		}
        
		while(true){
			// System.out.println(count+" "+number);
			if(number%5==0){
				
				count+=number/5;
				break;
				
			}else if(number%3==0){
				
				count+=number/3;
				break;
                
			}else if(number>5){
				count++;
				number-=5;
			}else{
				count=-1;
				break;
			}
		}
		
		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
}
// 2839 END

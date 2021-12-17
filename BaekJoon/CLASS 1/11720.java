// 11720
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int sum = 0;
    
		for(int i = 0; i < number; i++){
			sum+=input.charAt(i)-'0';
		}
		
		System.out.println(sum);
		
		br.close();
		System.exit(0);
	}
}
// 11720 end

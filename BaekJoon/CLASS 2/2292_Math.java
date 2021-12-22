// 벌집
// 2292
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		int ans = 1;
		int increment = 6;
		int count = 1;

		/*
    층별 끝나는 숫자 / 각 층의 개수 증가량
		1 +6
		7 +12
		19 +18
		37 +24
		61
		*/
		
		while(ans < number){
			ans += increment;
			count++;
			increment += 6;
		}

		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
}
// 2292 END

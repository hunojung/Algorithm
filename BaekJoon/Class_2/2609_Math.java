// 최대공약수와 최소공배수
// 2609 풀이 1
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());
		
		int yak = number>number2?number2:number;
		int bae = number<number2?number2:number;
		
		while(number%yak != 0 || number2%yak != 0){
				yak--;
		}
		
		while(bae%number != 0 || bae%number2 != 0){
			bae ++;
		}
		

		System.out.println(yak);
		System.out.println(bae);
		
		br.close();
		System.exit(0);
	}
}
// 2609 풀이 1 END


// 시간이 3배 단축되었다
// 2609 풀이 2 유클리드 호제법 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());
		
		int gcd = number>number2?gcd(number,number2):gcd(number2,number);
		int lcm = number*number2 / gcd;

		System.out.println(gcd);
		System.out.println(lcm);
		
		br.close();
		System.exit(0);
	}
	
	 public static int gcd(int p, int q)
	 {
		 return q==0?p:gcd(q,p%q);
	 }
}

// 2609 풀이 2 유클리드 호제법 END

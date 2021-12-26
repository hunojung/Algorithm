// 분산처리
// 1009
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 2 - 2 4 8 6 ,
			// 3 - 3 9 7 1 ,
			// 7 - 7 9 3 1 ,
			// 8 - 8 4 2 6 ,
			// 4 - 4 6 ,
			// 9 - 9 1 ,
			// 5 - 5 , 
			// 6 - 6 ,
			
			// a = 2 3 7 8
			a = a%10==0?10:a%10;
			
			if( a==10 || a == 1 || a == 5 || a == 6 ){
				System.out.println(a);
			}else if(a == 2 ||a == 3 || a == 7 || a == 8){
				b = b%4==0?4:b%4;
				System.out.println((int)(Math.pow(a, b)%10));
			}else if( a == 4 ||a == 9 ){
				b = b%2==0?2:b%2;
				System.out.println((int)(Math.pow(a, b)%10));
			}
		}

		br.close();
		System.exit(0);
	}
}
// 1009 END

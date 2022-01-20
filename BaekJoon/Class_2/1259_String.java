// 팰린드롬수
// 1259
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			int num = Integer.parseInt(br.readLine());
			if(num==0)break;
			int num2=num;
			int cnum=0;
			while(num2>0){
				cnum=cnum*10+num2%10;
				num2/=10;
			}
			if(num==cnum)System.out.println("yes");
			else System.out.println("no");
		}

		br.close();
		System.exit(0);

	}

}
// 1259 END

// 1436
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		int number = 0;
		String sixsixsix = "";
		
		while(true){
			number++;
			sixsixsix = number+"";
			if(sixsixsix.contains("666"))count++;
			if(count==num)break;
		}
		System.out.println(sixsixsix);

		br.close();
		System.exit(0);

	}

}
// 1436 END

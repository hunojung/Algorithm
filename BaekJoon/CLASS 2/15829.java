// HASING
// 15829
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int len = Integer.parseInt(br.readLine());
		String text = br.readLine();
		long hashnum = 0;
		long pow = 1;
		int mod = 1234567891;
		
		for (int i = 0; i < len; i++) {
			hashnum += (text.charAt(i)-'a'+1)*pow;
			pow = (pow * 31) % mod;
		}
		
		System.out.println(hashnum%mod);
		br.close();
		System.exit(0);
	}

}
// 15829 END

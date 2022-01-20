// IOIOI

// 50점
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		String IO = "I";
		for (int i = 0; i < N; i++) {
			IO+="OI";
		}
		int count = 0;
		int index = 0;
		
		while(S.indexOf(IO)!=-1){
		
			index = S.indexOf(IO);
			S = S.substring(index+2);
			count++;
		
		}
		
		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
}
// 50점 END

// 100점
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		int count = 0 ;
		int result = 0;
		for (int i = 1; i < M-1; i++) {
			
			if(S.charAt(i-1)=='I' && S.charAt(i)=='O' && S.charAt(i+1)=='I'){
				count++;
				if(count==N){
					count--;
					result++;
				}
				i++;
			}else{
				count = 0;
			}
		}
		System.out.println(result);
		
		br.close();
		System.exit(0);
	}
}
// 100점 END

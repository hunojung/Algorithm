// 동전 0
// 11047
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] moneys = new int[N];
		for (int i = 0; i < N; i++) {
			moneys[i]=Integer.parseInt(br.readLine());
		}
		
		int index = N-1;
		int count = 0;
		while(M > 0){
			//System.out.println(M+" "+index+" "+moneys[index]+" "+count);
			if(M >= moneys[index]){
				M-=moneys[index];
				count++;
			}else{
				index--;
			}
		}
		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
}
// 11047 END

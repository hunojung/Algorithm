// 주유소
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력 
		int city = Integer.parseInt(br.readLine());
		long[] D = new long[city-1];
		long[] P = new long[city];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < city-1; i++) {
			D[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());		
		for(int i=0 ; i < city ; i++){
			P[i]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(run(D,P));
		
		br.close();
		System.exit(0);
	}
	
	static long run(long[] D, long[] P){
		
		int last = P.length;
		int s = 0;
		int e = 1;
		long price = 0;
		while(e<last){
			
			if(e==last-1 || P[s]>P[e]){
				//System.out.println(s+" "+e);
				for (int i = s; i < e; i++) {
					price += D[i]*P[s];
				}
				s=e;
			}
			e++;
		}
		return price;
	}
}

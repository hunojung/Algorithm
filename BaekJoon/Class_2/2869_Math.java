// 달팽이는 올라가고 싶다
// 2869
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int day = 1 ;
		
		if(V-A>0){
			day += Math.ceil((double)(V-A)/(A-B));
		}
		System.out.println(day);
		
		br.close();
		System.exit(0);
	}
}
// 2869 END

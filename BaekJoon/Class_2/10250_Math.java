// ACM 호텔
// 10250
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			// 사람이 H 만큼 있을때 마다 호수 +1 이니까 H/N+1
			// 나누어 떨어지면 꼭대기 층이니까 +1 안해준다
			int room = N%H==0?(N/H):(N/H) +1 ;
			
			// 나누어 떨어지면 0이되니까 H로 해준다.
			N = N%H==0?H:N%H;
			room += N*100;
			System.out.println(room);
		}
		
		br.close();
		System.exit(0);
	}
}
// 10250 END

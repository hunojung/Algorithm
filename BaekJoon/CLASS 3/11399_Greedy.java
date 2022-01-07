// ATM
// 11399
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(st.nextToken()));			
		}
		
		int sum = 0;
		while(N-->0){
			sum+=q.poll()*(N+1);
    }
		System.out.println(sum);
		
		br.close();
		System.exit(0);
	}
}
// 11399 END

// 최소 힙
// 1927
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while(testcase-->0){
			int number = Integer.parseInt(br.readLine());
			if(number == 0){
				if(pq.isEmpty()){
					sb.append(0).append("\n");
				}else{
					sb.append(pq.poll()).append("\n");
				}
			}else{
				pq.add(number);
			}
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
// 1927 END

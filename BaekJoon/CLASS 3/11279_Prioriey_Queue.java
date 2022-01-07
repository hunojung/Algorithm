// 최대 힙
// 11279
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		int number;
		while(N-->0){
			number = Integer.parseInt(br.readLine());
			
			if(number != 0){
				pQ.add(number);
			}else{
				if(!pQ.isEmpty()){
					sb.append(pQ.poll()).append("\n");					
				}else{
					sb.append(0).append("\n");					
				}
			}
		}
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
// 11279 END

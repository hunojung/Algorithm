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

// 절댓값 힙
// 11286
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
		
		// 음수를 넣고 가장 큰 거 = 0에 가까움
		PriorityQueue<Integer> mQ = new PriorityQueue<>(Collections.reverseOrder());
		// 양수를 넣고 가장 작은거 = 0에 가까움
		PriorityQueue<Integer> pQ = new PriorityQueue<>();

		int number;
		
		while(N-->0){
			number = Integer.parseInt(br.readLine());
			
			// 입력
			if(number != 0){
				if(number < 0){
					mQ.add(number);
				}else{
					pQ.add(number);
				}
			}else{
				
				if(!pQ.isEmpty() || !mQ.isEmpty()){
					
					if(!pQ.isEmpty() && (mQ.isEmpty() || -mQ.peek()>pQ.peek())){
						sb.append(pQ.poll()).append("\n");											
					}else{
						sb.append(mQ.poll()).append("\n");																	
					}
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
// 11286 END

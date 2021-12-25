// 덱
// 10866
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		
		String command;
		for (int i = 0; i < testcase; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push_front")){
				
				deque.addFirst(Integer.parseInt(st.nextToken()));
				
			}else if(command.equals("push_back")){
				
				deque.addLast(Integer.parseInt(st.nextToken()));
				
			}else if(command.equals("pop_front")){
				
				if(deque.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(deque.pollFirst());
				}
				
			}else if(command.equals("pop_back")){
				
				if(deque.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(deque.pollLast());
				}
				
			}else if(command.equals("size")){
				
				System.out.println(deque.size());
				
			}else if(command.equals("empty")){
				
				if(deque.isEmpty()){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
				
			}else if(command.equals("front")){
				
				if(deque.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(deque.peekFirst());
				}
				
			}else if(command.equals("back")){
				
				if(deque.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(deque.peekLast());
				}
				
			}
		}
		
		br.close();
		System.exit(0);
	}
}
// 10866 END

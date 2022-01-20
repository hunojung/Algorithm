// 큐
// 10845
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		String command;
		int number = -1;
		for (int i = 0; i < testcase; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push")){
				number = Integer.parseInt(st.nextToken());
				queue.add(number);
				
			}else if(command.equals("pop")){
				
				if(queue.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(queue.poll());
					if(queue.isEmpty()) number = -1;
				}
				
			}else if(command.equals("size")){
				
				System.out.println(queue.size());
				
			}else if(command.equals("empty")){
				
				if(queue.isEmpty()){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
				
			}else if(command.equals("front")){
				
				if(queue.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(queue.peek());
				}
				
			}else if(command.equals("back")){
				
				System.out.println(number);
				
			}
		}
		
		br.close();
		System.exit(0);
	}
}
// 10845 END

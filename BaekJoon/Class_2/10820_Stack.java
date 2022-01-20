// 스택
// 10828
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		String command;
		int number;
		for (int i = 0; i < testcase; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push")){
				
				stack.push(Integer.parseInt(st.nextToken()));
				
			}else if(command.equals("pop")){
				
				if(stack.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(stack.pop());
				}
				
			}else if(command.equals("size")){
				
				System.out.println(stack.size());
				
			}else if(command.equals("empty")){
				
				if(stack.isEmpty()){
					System.out.println(1);
				}else{
					System.out.println(0);
				}
				
			}else if(command.equals("top")){
				
				if(stack.isEmpty()){
					System.out.println(-1);
				}else{
					System.out.println(stack.peek());
				}
				
			}
		}
		
		br.close();
		System.exit(0);
	}
}
// 10828 

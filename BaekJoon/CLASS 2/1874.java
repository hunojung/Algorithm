// 스택 수열
// 1874
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
        
		// 그냥 String에 추가하니 메모리 초과 에러발생한다
		StringBuilder ans = new StringBuilder();
		
		Stack<Integer> aNum = new Stack<>();
		
		int push = 0;
		int numbers;
		while(number-- > 0){
			
			numbers = Integer.parseInt(br.readLine());
			if(push < numbers){
				
				for (int i = push+1; i <= numbers; i++) {			
					aNum.push(i);
					ans.append("+\n");
				}
				push = numbers;
				
			}else if(aNum.peek()  != numbers){
				System.out.println("NO");
				System.exit(0);
			}
			
			aNum.pop();
			ans.append("-\n");
		}
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
}
// 1874 END

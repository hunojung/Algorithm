// 제로
// 10773
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		int num;
		int sum = 0;
		Stack<Integer> numbers = new Stack<>();
		while(testcase-->0){
			num = Integer.parseInt(br.readLine());
			if(num==0){
				numbers.pop();
			}else{
				numbers.add(num);
			}
		}
		
		Iterator<Integer> iter = numbers.iterator();
		while(iter.hasNext()){
			sum+=iter.next();
		}
		System.out.println(sum);
		br.close();
		System.exit(0);
	}
}
// 10773 END

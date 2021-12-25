// 괄호
// 9012
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		while(number-->0){
			Stack<Character> backet = new Stack<>();
			String ans = "YES";
			String backets = br.readLine();
			
			for (int i = 0; i < backets.length(); i++) {
				if('('== backets.charAt(i)){
					backet.add(backets.charAt(i));
				}else{
					
					if(backet.isEmpty() || backet.peek() != '('){
						ans="NO";
						break;
					}else{
						backet.pop();
					}
				}
			}
			
			if(!backet.isEmpty()) ans = "NO";
			
			System.out.println(ans);
		}
		
		br.close();
		System.exit(0);
	}
}
// 9012 END

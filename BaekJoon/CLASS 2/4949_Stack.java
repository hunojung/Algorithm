// 균형잡힌 세상
// 4949
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String ans = "yes";
			String words = br.readLine();
			if(words.equals(".")) break;
			
			char nextWords;
			Stack<Character> bracket = new Stack<>();
			
			for (int i = 0; i < words.length(); i++) {
				nextWords = words.charAt(i);
				if(nextWords == '(' || nextWords == '[' ){
					bracket.add(nextWords);
				}else if(nextWords == ')'){
					
					if(bracket.isEmpty()||'('!=bracket.pop()){
						ans = "no";
						break;
					}
						
				}else if(nextWords == ']'){
					if(bracket.isEmpty()||'['!=bracket.pop()){
						ans = "no";
						break;
					}
				}
			}
			
			if(!bracket.isEmpty())
				ans = "no";
			System.out.println(ans);
		}
		
		br.close();
		System.exit(0);
	}
}
// 4949 END

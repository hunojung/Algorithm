// AC
// 5430
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(testcase-->0){
			
			boolean error = false;
			boolean r = false;
			
			String p = br.readLine();
			p = p.replaceAll("RR", "");

			int N = Integer.parseInt(br.readLine());
			
			// ArrayList 말고 ArrayDeque 써야 됨
			ArrayDeque<Integer>number = new ArrayDeque<>();
			// ArrayList<Integer> number = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
			
			for (int i = 0; i < N; i++) {
				number.add(Integer.parseInt(st.nextToken()));
			}
			
			// p 명령 수행
			for (int i = 0; i < p.length(); i++) {
				char next = p.charAt(i);
				if(next=='R'){
					r = !r;
				}else{
					if(number.isEmpty()){
						error = true;
						break;
					}
					
					if(!r){
						number.pollFirst();
					}else{
						number.pollLast();
					}
				}
			}
			
			// 답안 작성
			if(error){
				sb.append("error").append("\n");
			}else{				
				sb.append("[");
				int size = number.size();
				for (int i = 0; i < size; i++) {
					if(i>0)sb.append(",");
					
					if(r){
						sb.append(number.pollLast());
					}else{
						sb.append(number.pollFirst());
					}
				}
			
				sb.append("]").append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
// 5430 END

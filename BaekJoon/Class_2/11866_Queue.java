// 요세푸스 문제 0
// 11866
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			q.add(i);
		}
		
		sb.append("<");
		// 7 3
		//<3, 6, 2, 7, 5, 1, 4>
		int count = K;
		while(!q.isEmpty()){
			
			if(count>1){
				count--;
				q.add(q.poll());
			}else{
				count=K;
				if(sb.length()>1) sb.append(", ");
				sb.append(q.poll());
			}

		}
		
		sb.append(">");
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
// 11866 END

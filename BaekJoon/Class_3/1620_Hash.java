// 나는야 포켓몬 마스터 이다솜
// 1620
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, String> poket = new HashMap<>();
		
		for (int i = 1; i < N+1; i++) {
			String next = br.readLine();
			String number = Integer.toString(i);
			poket.put(number,next);
			poket.put(next, number);
		}
		
		for (int i = 0; i < M; i++) {
			String next = br.readLine();
			sb.append(poket.get(next)).append("\n");				
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
// 1620 END

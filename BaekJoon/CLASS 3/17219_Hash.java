// 비밀번호 찾기
// 17219
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] confirmed;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,String> list = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.put(st.nextToken(),st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(list.get(site)).append("\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
// 17219 END

// 듣보잡
// 1764
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> member = new HashMap<>();
		HashMap<String, String> member2 = new HashMap<>();
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			member.put(name, name);
		}
		
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			member2.put(name, name);
		}
    
    // 교집합
		member2.entrySet().retainAll(member.entrySet());
    
    // key들을 얻은 후 정렬하고 출력
		Object[] keys = member2.keySet().toArray();
		Arrays.sort(keys);
		for(Object n : keys){
			count++;
			sb.append((String)n).append("\n");
		}
		System.out.println(count);
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
// 1764 END

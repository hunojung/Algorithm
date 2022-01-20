// 패션왕 신해빈
// 9375
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			int number = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<>();
			for (int i = 0; i < number; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String kind = st.nextToken();
				hm.put(kind, hm.getOrDefault(kind, 0)+1);			
			}
			sb.append(haebin(hm)).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	public static int haebin(HashMap<String,Integer> hm){
		
		Object[] keys = hm.keySet().toArray();

		int sum = 1;
		for(Object key : keys){
			Integer number = hm.remove((String)key);
			//System.out.println(key+" "+number);
			// remove시 value값이 나온다.
			sum*=(number+1);
		}
		return sum-1;
	}
}
// 9375 END

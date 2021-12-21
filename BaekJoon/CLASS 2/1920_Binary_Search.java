// 수 찾기
// 1920 SET의 contains 메소드를 활용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		HashSet<Integer> numbers = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < number; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		
		number = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int comp;
		for (int i = 0; i < number; i++) {
			comp = Integer.parseInt(st.nextToken());
			if(numbers.contains(comp))System.out.println(1);
			else System.out.println(0);
		}
		
		br.close();
		System.exit(0);

	}
}
// 1920

// 수 정렬하기 2
// 2751
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


// BufferedReader + ArrayList + Collections.sort : 시간초과
// BufferedReader + int[] + Arrays.sort : 시간초과
// BufferedReader + PriorityQueue : 통과
// Scanner + ArrayList + Collections.sort : 통과
// BufferedReader + ArrayList + Collections.sort : 통과 Scanner보다 시간/ 메모리 적게 들어감


public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner in = new Scanner(System.in);
		
//		int N = in.nextInt();
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder str = new StringBuilder();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
//			numbers.add(in.nextInt());
			numbers.add(Integer.parseInt(br.readLine()));
		}
		
		// Arrays.sort : 시간초과
		Collections.sort(numbers);
		
		for (int i = 0; i < N; i++) {
			
			// System.out.println(numbers.remve(0)) : 시간초과
			// numbers.remove(0) : 시간초과
			str.append(numbers.get(i)).append('\n');
		}
		
		System.out.println(str);

		br.close();
		System.exit(0);
	}
}
// 2751 END

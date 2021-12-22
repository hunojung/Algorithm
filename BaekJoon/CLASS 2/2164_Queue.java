// 카드2
// 2164
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		
		Queue<Integer> cards = new LinkedList<>();
		
//    변수 타입만 큐로 바꿔줬는데 시간초과 통과하였다.
//		ArrayList<Integer> cards = new ArrayList<>();
		
		for (int i = 0; i < number; i++) {
			cards.add(i+1);
		}
		
		while(cards.size() > 1){
			cards.poll();
			cards.add(cards.poll());
		}
		
		System.out.println(cards.poll());
		
		br.close();
		System.exit(0);
	}
}
// 2164 END

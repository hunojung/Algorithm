// 나무 자르기
// 2805
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int treeN = Integer.parseInt(st.nextToken());
		long sum_goal = Long.parseLong(st.nextToken());
		ArrayList<Long> numbers = new ArrayList<>();
		
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < treeN; i++) {
			numbers.add(Long.parseLong(st.nextToken()));
		}
		
		Collections.sort(numbers);
		long bottom = 0;
		long top = numbers.get(numbers.size()-1);
		long height;
		while(bottom<=top){
			sum = 0;
			height = (top+bottom)/2;
			for (int i = 0; i < treeN; i++) {
				if((numbers.get(i)-height) > 0)
					sum += (numbers.get(i)-height);
			}
			
			if(sum >= sum_goal){
				bottom = height+ 1;
			}else{
				top = height-1;
			}
		}
		
		System.out.println(top);
		br.close();
		System.exit(0);
	}
}
// 2805 END

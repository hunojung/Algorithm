// 수 정렬하기 3
// 10989 풀이 1
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] numbers = new int[testcase];
		
		for (int i = 0; i < testcase; i++) {
			numbers[i]=(Integer.parseInt(br.readLine()));
		}
		
		Arrays.sort(numbers);
		
		for (int i = 0; i < testcase; i++){
			sb.append(numbers[i]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
// 10989 풀이 1 END

// 10989 풀이 2
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] numbers = new int[10001];
		
		for (int i = 0; i < testcase; i++) {
			numbers[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();

		for (int i = 1; i < 10001; i++){
			while(numbers[i]>0){
				sb.append(i).append("\n");
				numbers[i]--;
			}
		}
		
		System.out.println(sb);
		
		System.exit(0);
	}
}
// 10989 풀이 2 END

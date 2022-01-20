// ATM
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력 
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		int sum = 0;
		int people = N;
		for (int i = 0; i < N; i++) {
			sum+=time[i]*people;
			people--;
		}
		
		System.out.println(sum);
		
		br.close();
		System.exit(0);
	}
}

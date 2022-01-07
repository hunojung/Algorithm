// 구간 합 구하기 4
// 11659
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] sums = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			sums[i] = sums[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// 누적 합을 이용해서
			// 9 ~ 14 구간 합을 구한다
			// 누적14까지합 - 누적8까지합
			sb.append(sums[e]-sums[s-1]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
// 11659 END

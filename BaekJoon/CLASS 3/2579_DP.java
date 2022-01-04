// 계단 오르기
// 2579
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N= Integer.parseInt(br.readLine());
		int[] stair = new int[N];
		
		for (int i = 0; i < N; i++) {
			stair[i]=Integer.parseInt(br.readLine());
		}
		
		// 각각의 index까지 최댓값을 계속 누적해온다?
		// 그렇게되면 특정 index에서 최댓값은 
		// 해당 인덱스 + ( sum(index-3) + index-1 합 or sum(index-2) ) 
		int[] sum = new int[N];
		sum[0] = stair[0];
		sum[1] = stair[1]+sum[0];
		sum[2] = stair[2]+Math.max(stair[0], stair[1]);
		
		// 10 , 20 , 15 , 25 , 10 , 20
		for (int i = 3; i < N; i++) {
			sum[i] = stair[i]+Math.max(sum[i-3]+stair[i-1], sum[i-2]);
		}
		
		System.out.println(sum[N-1]);
		
		br.close();
		System.exit(0);
	}
}
// 2579 END

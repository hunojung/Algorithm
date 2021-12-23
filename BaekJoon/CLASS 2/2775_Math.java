// 부녀회장이 될테야
// 2775
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
        
		while(testcase-- > 0){
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] floor_sum = new int[k+1][n];
			/*
			 * 1 2 3 4 5 6 7 8 9 
			 * 1 3 6 10 15 21 28 36 45
			 * 1 4 10 20 34 55 83 ..
			 * 1 5 15  35
			 * 1 6 21 56
			 * 
			 */
			// 0층에 값 채우기
			for(int i=0 ; i<n ; i++){
				floor_sum[0][i]=i+1;
			}
			
			// k = 층수 / n = 호수
			// 층 수만큼 포문 진행
			// 0층이면 안하고 1층이면 1번 함
			for (int f = 1 ; f < k+1; f++) {
				
				for (int h = 0; h < n; h++) {
					if(h==0){
						floor_sum[f][h]=1;
					}else{
						floor_sum[f][h]=floor_sum[f-1][h]+floor_sum[f][h-1];
					}
				}
			}
			
			System.out.println(floor_sum[k][n-1]);
		}
		
		br.close();
		System.exit(0);
	}
}

//2775 END

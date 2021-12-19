// 1654
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int[] lines = new int[number];
    
		long start = 1;
		long end = 0;
		long mid;
		
		// 라인 길이들 입력 및 최댓값 입력
		for (int i = 0; i < number; i++) {
			lines[i] = Integer.parseInt(br.readLine());
			if(end < lines[i])end = lines[i];
		}

		// 총 생성 가능한 라인 수
		int count;	
		
		// 라인 길이 바꿔가며 라인 수 검토
		while(start <= end){

			// 생성 가능 라인 수 초기화
			count = 0;
      
      // start , end 를 int 선언하며 여기서 int 허용치를 넘을 수 있다.
			mid = (start+end)/2;
			
			// 라인 수 세기, int 자동으로 소수점 삭제
			for (int i = 0; i < number; i++) {
				count += lines[i]/mid;
			}
			
			if(count >= goal){
				start = mid + 1;
			}else{
				end = mid -1;
			}

		}
		
		System.out.println(end);
		br.close();
		System.exit(0);

	}

}
// 1654 END

// 마인 크래프트
// 18111
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int first_block = Integer.parseInt(st.nextToken());
		
		int[][] maps = new int[x][y];
		int max = 0;
		
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				maps[i][j]=Integer.parseInt(st.nextToken());
				if(max< maps[i][j]) max= maps[i][j];
			}
		}

		br.close();
		
		// block = avg 높이가 되는데 필요한 블럭 수
		// time
		int before_time=0;
    
		// max 부터 시작해서 1개씩 내려간다
		// 시간이 줄어들다가 늘어나는 시점에 break
		while(true){
			int block = first_block;
			int time = 0;
			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					
					// 기준 높이와 차이 diff
					int diff = maps[i][j]-max;
					if( diff < 0 ){
						time -= diff;
						block += diff;
					}else if(diff > 0){
						time+=2*diff;
						block += diff;
					}
				}
			}
			//System.out.println("time:"+time+"/ b_time:"+before_time+"/ 기준:"+max+"/ block:"+block);
			if(block < 0){
				max --;
			}else{
				if(time == 0){
					System.out.println(time+" "+max);
					System.exit(0);
				}
				if(time >= before_time && before_time != 0 ){

					System.out.println(before_time+" "+(max+1));
					System.exit(0);
				}
				// block이 남는 순간부터 before_time에 넣고 비교시작
				before_time = time;
				max--;
			}
		}
		

// 참고한 반례
//		1 3 0
//		1 4 1
//		답 : 6 2
		
//		1 1 0
//		9
//		답 : 0 9

	}
}
// 18111 END

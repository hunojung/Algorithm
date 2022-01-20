// 회의실 배정
// 1931
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	//[][0] = start , [][1] = end
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] time = new int[testcase][2];
		
		for (int i = 0; i < testcase; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0]=Integer.parseInt(st.nextToken());
			time[i][1]=Integer.parseInt(st.nextToken());
		}
		// 서로 겹치지 않는 활동에 대해 종료시간이 빠르면
		// 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것
		// 빨리 끝나는걸 골라야 하는 이유는
		// 1 3
		// 8 8
		// 4 8 
		// 일 경우 8 8이 먼저 선택되면 4 8 이 선택이 안된다.
		Comparator<int[]> c1= (o1,o2)->{
			if(o1[1]==o2[1]) return o1[0]-o2[0];
			else return o1[1]-o2[1];
		};

		Arrays.sort(time,c1);

		int count = 0;
		int end = 0;
		for (int i = 0; i < testcase; i++) {
			if(time[i][0]>=end){
				count++;
				end = time[i][1];
			}
		}
		System.out.println(count);
	
		br.close();
		System.exit(0);
	}
}
// 1931 END

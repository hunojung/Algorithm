// 회의실 배정
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] time = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			time[i][0]=s;
			time[i][1]=e;
		}
		
		
		// 끝나는 시간 기준으로 시간순 정렬
		// 끝나는 시간이 같으면 시작 시간순 정렬
		Arrays.sort(time,new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2){
				if(o1[1]==o2[1]){
					return o1[0]-o2[0];
				}else{
					return o1[1]-o2[1];
				}
				
			}
		});
		
		int end = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(end<=time[i][0]){
				end = time[i][1];
				count++;
			}
		}
		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
}

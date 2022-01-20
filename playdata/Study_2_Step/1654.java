// 랜선자르기
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[K];

		long R = 1;
		long L = 1;
		long mid = 0;
		
		for(int i = 0; i < K; i++) {
			lan[i]=Integer.parseInt(br.readLine());
			if(lan[i]>R)R=lan[i];
		}
		
		while(R>=L){
			int lanCount = 0;
			mid = (R+L)/2;
			for (int i = 0; i < K; i++) {
				lanCount += lan[i]/mid;
			}
			
			if(lanCount<N){
				R = mid-1;
			}else{
				L = mid+1;
			}
		}
		
		System.out.println(R);
		
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/problem/10041
// 관광

// 분류
// 수학
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int minNow = 0;

			// 현재 기준 2 사분면
			if(x1<=x && y1>=y){
				ans += Math.abs(x1-x)+Math.abs(y1-y);
			// 3 사분면
			}else if(x1<x && y1<y){
				minNow = Math.min((x-x1),(y-y1));
				ans += (Math.abs(x1-x)+Math.abs(y1-y));
				ans -= minNow;
				
			// 4 사분면
			}else if(y1<=y){
				ans += (Math.abs(x1-x)+Math.abs(y1-y));
                
			// 1사분면
			}else{
				minNow = Math.min((x1-x),(y1-y));
				ans += (Math.abs(x1-x)+Math.abs(y1-y));
				ans -= minNow;
			}

			x = x1;
			y = y1;
		}

		System.out.println(ans);
		br.close();
		System.exit(0);
	}
}

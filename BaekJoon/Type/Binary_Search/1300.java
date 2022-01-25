// https://www.acmicpc.net/problem/1300
// K 번째 수

// 분류
// 이분 탐색
// 매개 변수 탐색
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = k;
		int mid = 0;
		while(left<=right){
			mid=(left+right)/2;
			
			// 각 행마다 mid보다 작은 것의 갯수를 센다!
			int sum = 0;
			for (int i = 1; i < N+1; i++) {
				sum+=Math.min(mid/i, N);
			}
			
			if(sum>=k){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		
		System.out.println(left);
		
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/problem/2343
// 기타 레슨

// 분류
// 이분 탐색
// 매개 변수 탐색
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] lecture = new int[N];
		int[] blu = new int[M];
		int mid = 0;
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < lecture.length; i++) {
			lecture[i]=Integer.parseInt(st.nextToken());
			right+=lecture[i];
			left = Math.max(left, lecture[i]);
		}
		
		while(left<=right){
			mid=(left+right)/2;
			int sum = 0;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				if(sum+lecture[i]>mid){
					cnt++;
					sum=lecture[i];
				}else{
					sum+=lecture[i];
				}
			}
			if(cnt<=M){
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

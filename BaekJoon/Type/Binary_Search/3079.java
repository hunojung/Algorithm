// https://www.acmicpc.net/problem/3079
// 입국심사

// sum += mid/time[i]; 부분이 포인트

// 분류
// 이분 탐색
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] time = new int[N];
		long mid = 0;
		long left = 0;
		long right = 0;
		for (int i = 0; i < N; i++) {
			time[i]=Integer.parseInt(br.readLine());
			right = Math.max(right, time[i]);
		}
		right=M*right;
		
		while(left<=right){
			mid=(left+right)/2;
			//System.out.println(left+" "+mid+" "+right);
			boolean bigger = confirm(mid,time,N,M);
			
			// mid가 크다
			if(bigger){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}
		
		System.out.println(left);
		
		br.close();
		System.exit(0);
	}
	
	static boolean confirm(long mid, int[] time,int N,int M){
		long sum = 0;
		boolean answer = false;
		
		for (int i = 0; i < N; i++) {
			sum += mid/time[i];
		}
		if(sum<M)answer=true;
		
		return answer;
	}
}

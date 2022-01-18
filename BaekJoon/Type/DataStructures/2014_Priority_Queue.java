// https://www.acmicpc.net/problem/2014
// 소수의 곱

// 분류
// 수학
// 자료 구조
// 정수론
// 우선순위 큐
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long[] n = new long[K];
		long ans = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			n[i]=Integer.parseInt(st.nextToken());
			pq.add(n[i]);
		}
		
		while(N-->0){
			ans = pq.poll();
			
			for (int j = 0; j < K; j++) {
				if(n[j]*ans>Integer.MAX_VALUE)continue;
				
				pq.add(n[j]*ans);
				
        // ans에 소수 리스트에 있는 값이 들어있으면
        // ans/소수 값에 다음 소수가 곱해진 수들이 있다
        // 그러면 (ans/소수1)*소수2,(ans/소수1)*소수3,(ans/소수1)*소수4 가 ans로 나올 수 있고
        // 그때 (ans/소수1)*소수2가 ans로 나왔을때 소수1을 곱해주면 앞에서 제외한 숫자가 생성이 가능하다
				if(ans%n[j]==0){
					break;
				}
			}
		}
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
}

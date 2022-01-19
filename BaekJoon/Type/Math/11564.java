// https://www.acmicpc.net/problem/11564
// 점프왕 최준민

// 분류
// 수학
// 정수론
// 많은 조건 분기
// 임의 정밀도 / 큰 수 연산


import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long k = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long ans = 0;
		
		// 0 포함하지 않고 한쪽에 a,b
		if(a>0 || b<0){
			a = Math.abs(a);
			b = Math.abs(b);
      
      // 둘중 작은게 k의 배수일 때 +1
			if(a<b) ans = Math.abs((b/k)-((a-1)/k));
            else ans = Math.abs((a/k)-((b-1)/k));
		}else{
			ans = b/k + (-a/k)+1;
		}
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
}

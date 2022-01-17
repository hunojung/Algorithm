// https://www.acmicpc.net/status?user_id=hunojung&problem_id=1783&from_mine=1
// 병든 나이트
import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		
		if(N == 1 || M == 1){
			ans = 1;
      
		}else if( N == 2){
			ans = Math.min((M+1)/2, 4);
      
		}else if(N>=3){
      // M이 4일때 (2,1), (-2,1), (2,1) 움직임으로 올 수 있다는걸 감안하자
			if(M<6){
        
				ans = Math.min(M, 4);
			}else{
				ans = M-2;
			}	
		}
		System.out.println(ans);
	}
}

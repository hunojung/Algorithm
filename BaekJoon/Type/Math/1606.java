// https://www.acmicpc.net/problem/1606
// 침투 계획 세우기

// 분류
// 수학
// 애드 혹
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Solution{
    
    public static void main(String[] args) throws Exception{
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
		
    	// 껍데기 수
    	long n = x+y;
    	long sum = 1;
    	
		for (int i = 1; i < n; i++) {
			sum += i*6;
		}
		if(y==0){
			sum+=n*6;
		}else{
			sum+=y;
		}
		
    	System.out.println(sum);
    	br.close();
    	System.exit(0);
	}
}

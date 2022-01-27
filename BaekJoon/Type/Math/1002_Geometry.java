// https://www.acmicpc.net/problem/1002
// 터렛

// 분류
// 수학
// 기하학
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int answer = 2;
			double L = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			
			if( L == 0 ){
				if(r1!= r2) answer = 0;
				else answer = -1;
			}else{
				if(L>r1+r2||L+r1<r2||L+r2<r1) answer = 0;
				else if(L==r1+r2 || L+r1==r2 || L+r2==r1)answer = 1;
			}			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

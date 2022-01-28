// https://www.acmicpc.net/problem/3009
// 네 번째 점

// 분류
// 구현
// 기하학
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		int x4 = 0;
		int y4 = 0;
		if(x1==x2)x4=x3;
		else if(x1==x3)x4=x2;
		else x4=x1;
		
		if(y1==y2)y4=y3;
		else if(y1==y3)y4=y2;
		else y4=y1;
		System.out.println(x4+" "+y4);
		br.close();
		System.exit(0);
	}
}

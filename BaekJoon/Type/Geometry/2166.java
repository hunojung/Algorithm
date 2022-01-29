// https://www.acmicpc.net/problem/2166
// 다각형의 넓이

// 아래 사이트 참고
// https://ko.wikihow.com/%EB%8B%A4%EA%B0%81%ED%98%95-%EB%84%93%EC%9D%B4-%EA%B5%AC%ED%95%98%EA%B8%B0

// 분류
// 기하학
// 다각형의 넓이
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] point = new int[N+1][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			point[i][0]=x;
			point[i][1]=y;
		}
		point[N][0]=point[0][0];
		point[N][1]=point[0][1];
        
		double area1 = 0;
		double area2 = 0;
		double area3 = 0;
		
		for (int i = 0; i < N; i++) {
			area1+=((long)point[i][0]*(long)point[i+1][1]);
			area2+=((long)point[i][1]*(long)point[i+1][0]);
		}

		area3=area1-area2;
		area3=area3/2;
		if(area3<0)area3*=-1;
		System.out.println(String.format("%.1f", area3));
		
		br.close();
		System.exit(0);
	}
}

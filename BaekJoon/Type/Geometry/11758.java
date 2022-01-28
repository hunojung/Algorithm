// https://www.acmicpc.net/problem/11758
// CCW

// 시계 방향일 때 좌표를 이용해 공식을 세운다.
// 시계 방향일때 area 공식을 기준으로 하니까 시계방향이면 양수로나온다.
// 반시계 방향이면 area가 음수가 나온다.
// 개어려워 ㅡㅡ

// 분류
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
		
		int area = (x3-x2)*(y2-y1)-(x2-x1)*(y3-y2);
		
		int answer = 0;
		if(area > 0)answer = -1;
		else if(area < 0)answer = 1;
		
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}

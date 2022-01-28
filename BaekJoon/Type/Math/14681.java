// https://www.acmicpc.net/problem/14681
// 사분면 고르기

// 분류
// 수학
// 구현
// 기하학
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int answer = 4;
		if(x>0 && y>0)answer=1;
		else if(x<0 && y>0)answer=2;
		else if(x<0 && y<0)answer=3;
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}

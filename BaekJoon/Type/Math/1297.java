// https://www.acmicpc.net/problem/1297
// TV 크기

// 분류
// 수학
// 기하학
// 피타고라스 정리
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int H2 = (int)(H*(D/Math.sqrt(H*H+W*W)));
		int W2 = (int)(W*(D/Math.sqrt(H*H+W*W)));
		
		System.out.println(H2+" "+W2);
		
		br.close();
		System.exit(0);
	}
}

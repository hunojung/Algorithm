// https://www.acmicpc.net/problem/1158
// 요세푸스 문제

// 분류
// 자료 구조
// 큐
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i < N+1; i++) {
			q.add(i);
		}
		int[] list = new int[N];
		int index=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K-1; j++) {
				q.add(q.poll());
			}
			list[i]=q.poll();
		}
		
		System.out.print("<");
		for (int i = 0; i < N; i++) {
			if(i>0)System.out.print(", ");
			System.out.print(list[i]);
		}
		System.out.println(">");
		br.close();
		System.exit(0);
	}
}

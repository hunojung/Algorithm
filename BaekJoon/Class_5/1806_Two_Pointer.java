// https://www.acmicpc.net/problem/1806
// 부분합
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i+1]=arr[i]+Integer.parseInt(st.nextToken());
		}
		
		int l = 0, r = 1;
		int answer = 0;
		while(l<=N && r<=N) {
			if(arr[r]-arr[l]>=S) {
				answer = answer==0?r-l:Math.min(answer, r-l);
				l++;
				if(l==r)
					r++;
			}else {
				r++;
			}
		}
		
		System.out.println(answer);
		
		br.close();
		System.exit(0);
	}
}

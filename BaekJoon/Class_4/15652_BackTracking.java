// https://www.acmicpc.net/problem/15652
// N과 M (4)
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BackTracking(N,new int[M],1,0,M);
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void BackTracking(int N,int[] res,int startIndex,int resIndex,int M){
		if(resIndex==M){
			for (int i = 0; i < resIndex; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = startIndex; i < N+1; i++) {
			res[resIndex]=i;
			BackTracking(N,res,i,resIndex+1,M);
		}

	}
}

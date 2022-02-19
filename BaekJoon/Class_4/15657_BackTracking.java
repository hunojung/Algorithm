// https://www.acmicpc.net/problem/15657
// N과 M (8)
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
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		BackTracking(nums,new int[M],0,0,M);
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void BackTracking(int[] nums,int[] res,int startIndex,int resIndex,int M){
		if(resIndex==M){
			for (int i = 0; i < resIndex; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = startIndex; i < nums.length; i++) {
			res[resIndex]=nums[i];
			BackTracking(nums,res,i,resIndex+1,M);
		}

	}
}

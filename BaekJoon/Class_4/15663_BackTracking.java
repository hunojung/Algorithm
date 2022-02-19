// https://www.acmicpc.net/problem/15663
// N과 M (9)
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
		boolean[] visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		BackTracking(visit,nums,new int[M],0,M);
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
	
	static void BackTracking(boolean[] visit,int[] nums,int[] res,int resIndex,int M){
		if(resIndex==M){
			for (int i = 0; i < resIndex; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			return;
		}
		int before = 0;
		for (int i = 0; i < nums.length; i++) {
			if(before==nums[i] || visit[i])continue;
			res[resIndex]=nums[i];
			visit[i]=true;
			BackTracking(visit,nums,res,resIndex+1,M);
			before=nums[i];
			visit[i]=false;
		}
	}
}

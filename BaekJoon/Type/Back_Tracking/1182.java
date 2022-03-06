// https://www.acmicpc.net/problem/1182
// 부분수열의 합
import java.io.*;
import java.util.*;

public class Main {
	static int N,S,ans=0;
	static int[] nums;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
        if(S==0)
            ans--;
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
	
	static void dfs(int idx,int sum){
		//System.out.println(idx+" "+nums[idx]+" "+sum);
		if(idx==N){
			if(sum==S)
				ans++;
			return;
		}

		dfs(idx+1,sum+nums[idx]);
		dfs(idx+1,sum);
	}
}

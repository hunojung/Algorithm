// https://www.acmicpc.net/problem/1037
// 약수
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		int min=0,max=0;
		for (int i = 0; i < N; i++) {
			nums[i]=Integer.parseInt(st.nextToken());
			if(i==0){
				min=nums[i];
				max=nums[i];
			}else{
				min=Math.min(min, nums[i]);
				max=Math.max(max, nums[i]);
			}
		}
		
		System.out.println(min*max);
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/problem/1062
// 가르침
import java.io.*;
import java.util.*;

public class Main {
	static int max,N,K;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		max = 0;
		int[] bit = new int[N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for(char c : s.toCharArray())
				bit[i] |= 1<<c-'a';
		}
		
		int mask = 1;
		mask = mask | 1<<('n'-'a');
		mask = mask | 1<<('t'-'a');
		mask = mask | 1<<('i'-'a');
		mask = mask | 1<<('c'-'a');
		backTracking(bit,mask,1,5);
		
		System.out.println(max);
		br.close();
		System.exit(0);
	}
	
	static void backTracking(int[] bit,int mask,int start,int count){
		if(count==K){
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if((mask & bit[i]) == bit[i])
					sum++;
			}
			max = Math.max(sum, max);
			
			return;
		}
		
		for(int i=start;i<26;i++){
			if((mask&(1<<i))!=0)continue;
			backTracking(bit,mask|(1<<i),i+1,count+1);
		}
	}
}

// https://www.acmicpc.net/problem/1007
// 벡터 매칭
import java.io.*;
import java.util.*;

public class Main {
	static double N,sumx,sumy;
	static double min;
	static List<int[]> list;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			min = -1;
			sumx = 0;
			sumy = 0;
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				sumx+=a;
				sumy+=b;
				list.add(new int[] {a,b});
			}
			vectorsum(0,0);
			
			System.out.println(min);
		}
		br.close();
		System.exit(0);
	}
	
	static void vectorsum(int idx,int count){
		if(count==N/2){
			double len = Math.sqrt(sumx*sumx+sumy*sumy);
			if(min==-1)min=len;
			else min=Math.min(min, len);
			return;
		}
		if(idx==list.size())
			return;
		
		int[] now = list.get(idx);
		sumx-=(now[0]*2);
		sumy-=(now[1]*2);
		vectorsum(idx+1,count+1);
		sumx+=(now[0]*2);
		sumy+=(now[1]*2);
		vectorsum(idx+1,count);
	}
}

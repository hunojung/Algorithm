// https://www.acmicpc.net/problem/16953
// A → B
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		int res = 1;
		boolean end = false;
		while(!q.isEmpty()){
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int now = q.poll();
				
				if(now>B)continue;
				
				if(now==B){
					end = true;
					break;
				}
				
				if(now<100000000)q.add(now*10+1);
				if(now<500000001)q.add(now*2);
			}
			
			if(end)break;
			
			res++;
		}
		if(end) System.out.println(res);
		else System.out.println(-1);
		br.close();
		System.exit(0);
	}
}

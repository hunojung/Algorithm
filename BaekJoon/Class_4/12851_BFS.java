// https://www.acmicpc.net/problem/12851
// 숨바꼭질 2
import java.io.*;
import java.util.*;

// 5 237
// 10
// 5
public class Main {
	static int min = Integer.MAX_VALUE, count = 1;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		boolean end = false;
		int count = 0;
		int time = 0;
		while(!q.isEmpty()){
			int len = q.size();
			for(int i=0;i<len;i++){
				int next = q.poll();
				set.add(next);
				if(next==K){
					end = true;
					count++;
				}
				
				if(!end){
					if(next>K){
						if(!set.contains(next-1)){
							q.add(next-1);
						}
					}else{
						if(!set.contains(next*2)){
							q.add(next*2);
						}
						
						if(!set.contains(next+1)){
							q.add(next+1);
						}
						
						if(!set.contains(next-1)){
							q.add(next-1);
						}
					}
				}
			}
			if(end)break;
			time++;
		}
		
		System.out.println(time+"\n"+count);
		br.close();
		System.exit(0);
	}
}

// https://www.acmicpc.net/problem/13549
// 숨바꼭질 3
import java.io.*;
import java.util.*;

public class Main {
	static int X = 1000000007;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] visit = new boolean[100001];
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int time = 0;
		
		PriorityQueue<Position> q = new PriorityQueue<>();
		if(N>=K) time = N-K;
		else q.add(new Position(N,0));
		
		while(!q.isEmpty()){
			Position now = q.poll();
			if(now.x==K){
				time = now.time;
				break;
			}
			
			if(visit[now.x] || now.x>100000)continue;
			//System.out.println(now[0]+" "+now[1]);

			visit[now.x]=true;
			
			if(now.x>0 && now.x*2<=100000){
				q.add(new Position(now.x*2,now.time));
			}
			if(now.x<100000){
				q.add(new Position(now.x+1,now.time+1));
			}
			if(now.x>1){
				q.add(new Position(now.x-1,now.time+1));
			}
		}
		
		System.out.println(time);
		
		br.close();
		System.exit(0);
	}
	
	static class Position implements Comparable<Position>{
		int x;
		int time;
		public Position(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
		@Override
		public int compareTo(Position o) {
			// TODO Auto-generated method stub
			return this.time-o.time;
		}
		
	}
}

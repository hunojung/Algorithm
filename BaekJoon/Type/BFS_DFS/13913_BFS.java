// https://www.acmicpc.net/problem/13913
// 숨바꼭질 4
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[100001];
		Queue<Path> q = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		list.add(N);
		
		if(N<=X){
			q.add(new Path(N,0,new ArrayList(list)));
		}else{
			sb.append(N-X).append("\n");
			for (int i = N; i > X-1; i--) {
				sb.append(i+" ");
			}
		}
		
		while(!q.isEmpty()){
			Path now = q.poll();
			
			visit[now.n]=true;
			
			if(now.n==X){
				sb.append(now.t+"\n");
				for (int i = 0; i < now.list.size(); i++) {
					sb.append(now.list.get(i)+" ");
				}
				break;
			}
			
			if(now.n>0 && !visit[now.n-1]){
				now.list.add(now.n-1);
				q.add(new Path(now.n-1,now.t+1,new ArrayList(now.list)));
				now.list.remove(now.list.size()-1);
			}
			
			if( now.n*2<100001 && now.n>0 && now.n<X &&!visit[now.n*2]){
				now.list.add(now.n*2);
				q.add(new Path(now.n*2,now.t+1,new ArrayList(now.list)));
				now.list.remove(now.list.size()-1);
			}
			
			if( now.n+1<100001 && now.n<X &&!visit[now.n+1]){
				now.list.add(now.n+1);
				q.add(new Path(now.n+1,now.t+1,new ArrayList(now.list)));
				now.list.remove(now.list.size()-1);
			}
		}
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	static class Path{
		int n;
		int t;
		List<Integer> list;
		public Path(int n,int t, List<Integer> list) {
			this.n = n;
			this.t = t;
			this.list = list;
		}
		
	}
}

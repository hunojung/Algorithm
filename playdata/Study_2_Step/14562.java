// 태권왕
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());

		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(new Kick(S,T,0))+"\n");
		}
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	static int bfs(Kick K){
		
		Queue<Kick> q = new LinkedList<>();
		q.add(K);
		
		while(!q.isEmpty()){
			K = q.poll();
			//System.out.println(K.s+" "+K.t+" "+K.count);
			if(K.s == K.t)break;
			// 2배킥
			if(K.s*2 <= K.t+3){
				q.add(new Kick(K.s*2,K.t+3,K.count+1));
			}
			
			// +1 킥
			q.add(new Kick(K.s+1,K.t,K.count+1));
		}
		
		return K.count;
	}
	
	static class Kick{
		int s;
		int t;
		int count;
		
		public Kick(int s, int t, int count) {
			super();
			this.s = s;
			this.t = t;
			this.count = count;
		}
	}
}

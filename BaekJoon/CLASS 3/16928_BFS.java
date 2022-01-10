// 뱀과 사다리
// 16928
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2 1
2 60
30 98
65 25
*/
// 뱀을 타는게 이득일때가 있다?!
public class Main {
	static int[] path = new int[101]; 
	static int N,M;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			path[a] = b;
		}
		
		System.out.println(dfs(N));
		br.close();
		System.exit(0);
	}
	
	static int dfs(int N){	
		
		int count = 0;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1,0));
		
		while(!q.isEmpty()){
			Point p = q.poll();
			//System.out.println(p.p+" "+p.c);
			
			// 100이면 종료
			if(p.p==100){
				count = p.c;
				break;
			// 사다리, 뱀
			}else if(path[p.p]!=0){
				
				// 사다리
				p.p=path[p.p];				
			}
			
			// 사다리 타기, 뱀타기( 제자리걸음 아닌거 ), 제외하고 최댓값
			boolean max = false;
			for (int i = 6; i > 0; i--) {
				if(p.p+i<101){
					// 100 안넘고, 사다리 , 뱀이 제자리 안도는거
					if(path[p.p+i]!=0 && path[p.p+i] != p.p){
						q.add(new Point(p.p+i,p.c+1));					
					}else{
						if(!max){
							q.add(new Point(p.p+i,p.c+1));					
						}
						max = true;
					}
				}
			}
		}
		return count;
	}
	
	static class Point{
		int p;
		int c;
		
		public Point(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
}
// 16928 END

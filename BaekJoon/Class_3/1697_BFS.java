// 숨바꼭질
// 1697
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] confirmed;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		confirmed = new int[100001];
		
		if(N>=M){
			System.out.println(N-M);
		}else{
			search(N,M);
		}
		
		br.close();
		System.exit(0);
	}
	
	public static void search(int N, int M){
		Queue<Integer> next = new LinkedList<Integer>();
		
		next.add(N);
		confirmed[N]=0;
		
		while(!next.isEmpty()){
			int now = next.poll();
			
			if(now==M)System.out.println(confirmed[now]);
			
			if(now > 0 && confirmed[now-1]==0){
				next.add(now-1);
				confirmed[now-1]=confirmed[now]+1;
			}
			
			if(now < confirmed.length-1 && confirmed[now+1]==0){
				next.add(now+1);
				confirmed[now+1]=confirmed[now]+1;
			}
			
			// 예문에서는 *2 한 값이 답+1 이었지만
			// now*2가 100001 이 될일이 없기 때문에 100000까지한다
			if(now*2<confirmed.length && confirmed[now*2]==0){
				next.add(now*2);
				confirmed[now*2]=confirmed[now]+1;
			}
		}
	}
}
// 1697 END

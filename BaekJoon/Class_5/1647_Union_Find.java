// 도시 분할 계획
import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		int answer = 0;
		int max = 0;
		for(int i=0;i<N+1;i++){
		    parent[i]=i;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    pq.add(new int[] {a,b,c});
		}
		
		while(!pq.isEmpty()){
		    int[] now = pq.poll();
            
            int a = find(now[0]);
            int b = find(now[1]);
		    if(a==b) continue;
		    
		    parent[a] = b;
		    answer+=now[2];
		    max = Math.max(max,now[2]);
		}
		
		System.out.println(answer-max);
		
		br.close();
		System.exit(0);

	}
	
	static int find(int a){
	    if(parent[a]==a) return a;
	    
	    return parent[a] = find(parent[a]);
	}
}

// 특정 거리의 도시 찾기
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 값 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int a,b;
		ArrayList<Integer>[] loadList = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			loadList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			// a->b 로 단방향 길 저장
			loadList[a].add(b);
		}
		
		
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		
		int[] check = new int[N+1];
		while(!q.isEmpty()){
			int next = q.poll();
			
			for (int i = 0; i < loadList[next].size(); i++) {
				if(check[loadList[next].get(i)] == 0){
					
					// 다음에 갈 곳이 안들린 곳이면 지금까지 온 길 + 1
					check[loadList[next].get(i)] = check[next]+1;
					q.add(loadList[next].get(i));
				}
			}
		}
		
		boolean ok = false;
		for (int i = 1; i < check.length; i++){
			if (check[i] == K && i != X) {
				ok = true; System.out.println(i);
			}
		}
			
		if(!ok) System.out.println(-1);

		br.close();
		System.exit(0);
	}
}

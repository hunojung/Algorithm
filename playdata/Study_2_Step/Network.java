// 네트워크
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int[] ok;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int N = computers.length;
        ok = new int[N];
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(computers[i][j]==1 || computers[j][i]==1){
					computers[i][j]=1;
					computers[j][i]=1;
				}
			}
		}
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(computers[i][j]==1 && ok[j]==0){
					answer++;
					bfs(computers,N,i);
				}
			}
		}
        
        return answer;
    }
	
	static void bfs(int[][] computers, int N, int a){
		
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		ok[a]=1;
		
		while(!q.isEmpty()){
			int next = q.poll();
			for (int i = 0; i < N; i++) {
				if(computers[next][i]==1 && ok[i] == 0){
					q.add(i);
					ok[i]=1;
				}
			}
		}
	}
}

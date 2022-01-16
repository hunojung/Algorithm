// https://programmers.co.kr/learn/courses/30/lessons/12978
// 배달
import java.util.*;

public class Solution{
	int[] ok;
	int[][] map;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ok = new int[N+1];
        map = new int[N+1][N+1];
        ok[1]=1;
        for (int i = 0; i < road.length; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int len = road[i][2];
			
			if(map[a][b] == 0 || len < map[a][b]){
				map[a][b]=len;
				map[b][a]=len;
			}
			
		}
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        
        while(!q.isEmpty()){
        	int now = q.poll();
        	
        	for (int i = 1; i < N+1; i++) {
				if(map[now][i] != 0 && (ok[i]==0 || map[now][i]+ok[now]<ok[i])){
					ok[i]=map[now][i]+ok[now];
					q.add(i);
				}
			}
        }
        
        for (int i = 1; i < N+1; i++) {
        	//System.out.println((ok[i]-1));
			if((ok[i]-1)<=K)answer++;
		}

        return answer;
    }
}

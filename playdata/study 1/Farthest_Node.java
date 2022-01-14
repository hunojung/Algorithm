 // https://programmers.co.kr/learn/courses/30/lessons/49189
// 가장 먼 노드
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        ArrayList<Integer>[] node = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
			node[i]=new ArrayList<>();
		}
        // 값 입력
        for (int i = 0; i < edge.length; i++) {
			int a = edge[i][0];
			int b = edge[i][1];
			node[a].add(b);
			node[b].add(a);
		}
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        int[] visit = new int[n+1];
        visit[1]=1;
        while(!q.isEmpty()){
        	int next = q.poll();
        	for (int i = 0; i < node[next].size(); i++) {
				if(visit[node[next].get(i)] == 0 || visit[node[next].get(i)] > visit[next]+1){
					visit[node[next].get(i)] = visit[next]+1;
					if(visit[node[next].get(i)]>max){
						max = visit[node[next].get(i)];
					}
					q.add(node[next].get(i));
				}
			}
        }
        
        for (int i = 0; i < n+1; i++) {
			if(visit[i]==max){
				answer++;
				//System.out.println(i);
			}
		}
        
        return answer;
    }
}

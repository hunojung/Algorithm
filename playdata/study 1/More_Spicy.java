// 더맵게
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 값 큐에 입력
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
			pq.add((long)scoville[i]);
		}
        
        while(pq.size()>1 && pq.peek()<K){
        	long a = pq.poll();
        	long b = pq.poll();
        	
        	pq.add(a+b*2);
        	answer++;
        }
        
        if(pq.size()==1 && pq.peek() < K){
        	return -1;
        }else{
        	return answer;	
        }
    }
}

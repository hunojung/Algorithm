// 프린터
import java.util.*;

public class Solution{
	static class Print{
		
		int location;
		int priorities;
		
		public Print(int location, int priorities) {
			this.location = location;
			this.priorities = priorities;
		}

		
	}
    public int solution(int[] priorities, int location) {
    	int answer = 1;
    	Queue<Print> q = new LinkedList<>();
    	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
        	q.add(new Print(i,priorities[i]));
        	pq.add(priorities[i]);
		}
        
        Print next = null;
        int comp;
        
        while(true){
			
        	next = q.poll();
			comp = pq.poll();
			//System.out.println(next.priorities+" "+next.location);
			
			// priorities가 최댓값이고 로케이션이 맞으면 출력
			if(comp == next.priorities){
				if(next.location==location){
					break;
				
				// priorities가 안맞으면 다시 추가
				}else{
					answer++;
				}
			// priorities 최대 아니면 다시
			}else{
				q.add(next);
				pq.add(comp);			
			}
		}
        return answer;
    }
}

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
        for (int i = 0; i < priorities.length; i++) {
        	q.add(new Print(i,priorities[i]));
		}
        
        Arrays.sort(priorities);
        
        Print next = null;
        int size = priorities.length;
        while(true){
			
        	next = q.poll();
			//System.out.println(next.priorities+" "+next.location);
			
			// priorities가 최댓값이고 로케이션이 맞으면 출력
			if(priorities[size-answer] == next.priorities){
				if(next.location==location){
					break;
				
				}else{
					answer++;
				}
				
			// priorities 최대 아니면 다시넣어
			}else{
				q.add(next);
			}
		}
        
        return answer;
    }
}

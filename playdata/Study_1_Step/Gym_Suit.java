// https://programmers.co.kr/learn/courses/30/lessons/42862
// 체육복
import java.util.*;

public class Solution{
	
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
    	HashSet<Integer> r = new HashSet<>();
    	
    	for (int i = 0; i < reserve.length; i++) {
			r.add(reserve[i]);
			
		}
    	
		for (int i = 0; i < lost.length; i++) {
			if(r.contains(lost[i])){
				r.remove(lost[i]);
				lost[i]=-1;
				answer++;
			}
		}
		
		Arrays.sort(lost);
		
		for (int i = answer; i < lost.length; i++) {
			
			int num = lost[i];
			
			if(r.contains(num-1)){
				r.remove(num-1);
				answer++;
			}else if(r.contains(num+1)){
				r.remove(num+1);
				answer++;
			}
		}
        return n+answer-lost.length;
    }
}

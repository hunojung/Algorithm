import java.util.*;

public class Solution{
	
    public int solution(int[] people, int limit) {
        int len = people.length;
        int answer = 0;
        
        Arrays.sort(people);
        int index_l = 0;
        int index_r = len-1;
        
        while(index_l<=index_r){
        	if(people[index_l]+people[index_r]<=limit){
        		index_l++;
        		index_r--;
        	}else{
        		index_r--;
        	}
        	answer++;
        }
        
        return answer;
    }
}

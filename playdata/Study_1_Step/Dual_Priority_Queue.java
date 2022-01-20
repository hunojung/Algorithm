// https://programmers.co.kr/learn/courses/30/lessons/42628
// 이중우선순위큐
import java.util.TreeMap;

public class Solution {
    public int[] solution(String[] operations) {
        int N = operations.length;
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for (int i = 0; i < N; i++) {
        	String[] next = operations[i].split(" ");
        	String oper = next[0];
        	int number = Integer.parseInt(next[1]);
        	
        	//System.out.println(oper+" "+number);
        	
        	if(oper.endsWith("I")){
        		tm.put(number,tm.getOrDefault(number, 0)+1);        		
        	}else{
        		if(!tm.isEmpty()){   			
        			if(number==1){
        				int key = tm.lastKey();
        				int value = tm.get(key);
        				
        				if(value>1){
        					tm.put(key, value-1);
        				}else{
        					tm.remove(key);
        				}
        			}else{
        				int key = tm.firstKey();
        				int value = tm.get(key);
        				
        				if(value>1){
        					tm.put(key, value-1);
        				}else{
        					tm.remove(key);
        				}
        			}
        		}
        	}
        }
        int[] ans = new int[2];
        if(!tm.isEmpty()){
        	ans[0] = tm.lastKey();
        	ans[1] = tm.firstKey();
        }
        
        return ans;
    }
}

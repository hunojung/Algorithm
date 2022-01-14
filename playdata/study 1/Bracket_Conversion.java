// https://programmers.co.kr/learn/courses/30/lessons/60058
// 괄호 변환
class Solution {
    public String solution(String p) {
        String answer = "";
        String answer_last="";
        String u = "";
        String v = "";
        
        // 공백이 들어오면 리턴
        if(p.equals(""))return "";
        
        // u가 정상인지 판단
        boolean alright = false;
        
    	int N = p.length();
    	int count = 0;
    	
    	// u와 v로 나눈다 . 나누면서 count가 음수이면 ')'가 많았다는 것
    	for (int i = 0; i < N; i++) {
			if(p.charAt(i)=='('){
				count++;
				// 분리된 u 가 정상인지 
				if(count>0)alright=true;
			}
			else{
				count--;
			}
			if(count==0){
				u = p.substring(0, i+1);
				v = p.substring(i+1,N);
				break;
			}
		}
    	
    	// u 가 정상
    	if(alright){
    		answer = answer+u;
    		
    	// u 가 비정상
    	}else{
    		int len = u.length();
    		String u_copy ="";
    		if(len>2){
    			u = u.substring(1,len-1);
    			for (int i = 0; i < len-2; i++) {
    				if(u.charAt(i)=='('){
    					u_copy = u_copy+")";
    				}else{
    					u_copy = u_copy+"(";
    				}
    			}
    		}
    		answer = answer+"(";
    		answer_last = ")"+u_copy+answer_last;
    	}
        
        return answer+solution(v)+answer_last;
    }
}

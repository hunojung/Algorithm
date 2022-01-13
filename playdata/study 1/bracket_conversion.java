// 괄호 변환
class Solution {
    public String solution(String p) {
    	
    	//System.out.println(p.substring(1,p.length()-1));
        String answer = "";
        String answer_last="";
        String u = "";
        String v = "";
        
        while(true){
        	boolean alright = false;
        	int N = p.length();
        	int count = 0;
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
        	
        	// u 가 정상인가
        	if(alright){
        		answer = answer+u;
        		if(v.length()==0)break;
        	// u 가 비정상인가
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
        		if(v.length()==0)break;
        	}
        	p=v;
        }
        return answer+answer_last;
    }
}

// https://leetcode.com/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String s) {
        
        long answer = 0;
        boolean minus = false;
        boolean processing = false;
        
        for(char c : s.toCharArray()){
            if(c<='9' && c>='0'){
                int num = c-'0';
                answer = answer*10+num;
                if(answer > Integer.MAX_VALUE){
                    break;
                }
                
            }else if(c=='-' || c=='+'){
                if(processing == false){
                    if(c=='-')minus = true;
                }else{
                    break;
                }
            }else if(c==' '){
                if(processing == false){
                    continue;
                }else{
                    break;
                }
            }else{
                break;
            }
            
            processing = true;
        }
        
        if(minus){
            answer *= -1;
            if(answer < Integer.MIN_VALUE){
                answer = Integer.MIN_VALUE;
            }
        }else{
            if(answer > Integer.MAX_VALUE){
                answer = Integer.MAX_VALUE;
            }
        }
        
        return (int)answer;
    }
}

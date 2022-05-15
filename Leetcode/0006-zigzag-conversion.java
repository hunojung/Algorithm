// https://leetcode.com/problems/zigzag-conversion/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<numRows;i++){
            int idx = i;
            int step1 = (numRows*2-2)-2*i;
            int step2 = 2*i;
            
            while(idx<s.length()){
                if(step1!=0 && idx<s.length()){
                    sb.append(s.charAt(idx));
                    idx += step1;
                }
                
                if(step2!=0 && idx<s.length()){
                    sb.append(s.charAt(idx));
                    idx += step2;
                }
            }
        }
        
        return sb.toString();
                       
    }
}

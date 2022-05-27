// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
class Solution {
    public int numSteps(String s) {
        if(s.length()<2) return 0;
        
        int count = 0;
        int two = 0;
        
        for(int i=s.length()-1;i>-1;i--){
            if(i==0 && two==0) continue;
            
            if((s.charAt(i)=='1' && two==0) || (s.charAt(i)=='0' && two==1)){
                two=1;
                count++;
            }else if(s.charAt(i)=='1' && two==1){
                two=1;
            }else{
                two=0;
            }
            count++;
        }
        
        return count;
    }
}

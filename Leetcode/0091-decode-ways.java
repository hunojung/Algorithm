// https://leetcode.com/problems/decode-ways/

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int prepre = 0,pre = 1;
        
        for(int i = 0; i<len;i++){
            int cur = 0;
            if(s.charAt(i)>='1') cur=pre;
            
            if(i>0 && ((s.charAt(i-1)=='1') || (s.charAt(i-1)=='2' && s.charAt(i) <= '6'))) {
                cur+=prepre;
            }
            prepre = pre;
            pre=cur;
        }
        
        return pre;        
    }
}

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) >= '1'? 1 : 0 ;
        
        for(int i = 1; i<len;i++){
            if(s.charAt(i)>='1') dp[i+1]=dp[i];
            
            if((s.charAt(i-1)=='1') || (s.charAt(i-1)=='2' && s.charAt(i) <= '6')) {
                dp[i+1]+=dp[i-1];
            }            
        }
        
        return dp[len];        
    }
}

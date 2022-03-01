// https://leetcode.com/problems/counting-bits/
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        // 11 = 8+3
        int two = 1;
        for(int i = 1 ; i<n+1 ; i++){
            if(i==two){
                dp[i]=1;
                two*=2;
            }else{
                dp[i]=dp[two/2]+dp[i-two/2];
            }
        }
        return dp;
    }
}

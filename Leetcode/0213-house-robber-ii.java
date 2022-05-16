// https://leetcode.com/problems/house-robber-ii/
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        
        if(len<=3){
            int max = 0;
            for(int i=0;i<len;i++)
                max = Math.max(max,nums[i]);
            return max;
        }
        
        int[][] dp = new int[2][len];
        
        for(int i=0;i<2;i++){
            dp[0][i]=nums[i];
            dp[1][i]=nums[len-1-i];
        }

        dp[0][2] = dp[0][0]+nums[2];
        dp[1][2] = dp[1][0]+nums[len-3];
        
        for(int i = 3;i<len-1;i++){
            dp[0][i]=Math.max(dp[0][i-2],dp[0][i-3])+nums[i];
            dp[1][i]=Math.max(dp[1][i-2],dp[1][i-3])+nums[len-1-i];
        }
        
        int max0 = Math.max(dp[0][len-2],dp[0][len-3]);
        int max1 = Math.max(dp[1][len-2],dp[1][len-3]);
        return Math.max(max0,max1);
    }
}

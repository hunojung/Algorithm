// https://leetcode.com/problems/jump-game-ii/
class Solution {
    // Dp
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length && j<=i+nums[i] ;j++){
                if(dp[j]==0 || dp[j]>dp[i]+1)dp[j]=dp[i]+1;
            }
        }
        
        return dp[nums.length-1];
    }
    
    // Greedy
    public int jump(int[] nums) {
        int maxIdx = 0, curIdx = 0,count = 0;
        
        for(int i=0;i<nums.length-1;i++){
            maxIdx = Math.max(maxIdx,i+nums[i]);
            if(i==curIdx){
                count++;
                curIdx = maxIdx;
            }
        }
        
        return count;
    }
}

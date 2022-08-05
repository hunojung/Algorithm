// https://leetcode.com/problems/combination-sum-iv/
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int tar = 1 ; tar<=target; tar++){
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] > tar) continue;
                sum += dp[tar-nums[i]];
            }
            dp[tar] = sum;
        }
        
        return dp[target];
    }
}

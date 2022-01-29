// https://leetcode.com/problems/maximum-subarray/
// update submit code
class Solution {
    public int maxSubArray(int[] nums) {
        int answer = nums[0];
    	int[] dp = new int[nums.length];
    	dp[0]=nums[0];
    	
    	// 누적합
    	for (int i = 1; i < nums.length; i++) {
			dp[i]=nums[i]+Math.max(dp[i-1],0);
			answer=Math.max(dp[i], answer);
		}
    	return answer;
    }
}

// first submit code
class Solution {
    public int maxSubArray(int[] nums) {
        int answer = nums[0];
    	int len = nums.length;
    	int[] dp = new int[len+1];
    	int[] dp2 = new int[len+1];
    	boolean up = false;
    	int max=0,min=0;
    	// 누적합
    	for (int i = 1; i < len+1; i++) {
			dp[i]=dp[i-1]+nums[i-1];
			if(dp[i]>dp[i-1])up=true;
			
			min=Math.min(min, dp[i]);
			if(up){
				answer = Math.max(dp[i]-min, answer);
			}else{
				answer = Math.max(dp[i]-dp[i-1], answer);
			}
		}
    	return answer;
    }
}

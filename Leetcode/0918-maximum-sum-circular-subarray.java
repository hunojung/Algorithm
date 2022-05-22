// https://leetcode.com/problems/maximum-sum-circular-subarray/
// 최솟값인 배열을 찾아서 빼면 그게 최댓값인 배열?
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int answer = Arrays.stream(nums).sum();
        
        int min = nums[0];
        int max = nums[0];
        
        int max_sum = 0;
        int min_sum = 0;
        
        for(int i = 0;i<nums.length;i++){
            min_sum += nums[i];
            max_sum += nums[i];
            
            min = Math.min(min_sum,min);
            max = Math.max(max_sum,max);
            
            if(min_sum>0) min_sum = 0;
            if(max_sum<0) max_sum = 0;
        }
        
        if(max>0) return Math.max(answer-min,max);
        
        return max;
    }
}

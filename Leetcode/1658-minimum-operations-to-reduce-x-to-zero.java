// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
class Solution {
    int answer;
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums) sum += num;
        
        int currSum = 0;
        int len = -1;
        for(int l=0,r=0;r<nums.length;r++){
            currSum+=nums[r];
            while(l<=r && currSum > sum-x){
                currSum-=nums[l];
                l++;
            }

            if(currSum == sum-x){
                if(len == -1) len = nums.length - 1 - (r-l);
                else len = Math.min(len,nums.length - 1 - (r-l));
            }
        }
        
        return len;
    }
}

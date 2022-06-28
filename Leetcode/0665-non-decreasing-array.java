// https://leetcode.com/problems/non-decreasing-array/
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean modify = false;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]) continue;
            
            if(modify) return false;
            
            if(i>0 && nums[i-1]>nums[i+1]){
                nums[i+1]=nums[i];
            }
            modify = true;
        }
        return true;
    }
}

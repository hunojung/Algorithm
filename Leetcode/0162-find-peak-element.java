// https://leetcode.com/problems/find-peak-element/
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        
        int left = 0, right = nums.length-1;
        
        while(left+1<right){
            int mid = (left+right)/2;
            
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid]>nums[mid-1]){
                left = mid;
            }else{
                right = mid;
            }
        }
        
        return nums[left]>nums[left+1]?left:right;
    }
}

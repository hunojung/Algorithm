// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length<1 || nums[0]>target || nums[nums.length-1]<target) return new int[] {-1,-1};
        int[] ans = new int[2];
        
        int l1=0,r1=nums.length-1;
        while(l1<=r1){
            int mid = (l1+r1)/2;
            if(nums[mid]<target){
                l1 = mid+1;
            }else{
                r1 = mid-1;
            }
        }
        
        if(nums[l1]!=target) return new int[] {-1,-1};
        
        int l2=0,r2=nums.length-1;
        
        while(l2<=r2){
            int mid = (l2+r2)/2;
            if(nums[mid]>target){
                r2 = mid-1;
            }else{
                l2 = mid+1;
            }
        }
        
        return new int[] {l1,r2};
    }
}

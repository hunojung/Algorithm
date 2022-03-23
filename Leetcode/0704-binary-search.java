// https://leetcode.com/problems/binary-search/
class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        if(nums[l]>target || nums[r]< target) return -1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]>=target)
                r=mid-1;
            else
                l=mid+1;
        }
        if(nums[l]!=target) return -1;
        
        return l;
    }
}

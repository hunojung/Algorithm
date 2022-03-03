// https://leetcode.com/problems/next-permutation/
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = -1;
        for(int i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        
        if(index>-1){
            for(int i=len-1;i>=0;i--){
                if(nums[i]>nums[index]){
                    int tmp = nums[i];
                    nums[i]=nums[index];
                    nums[index]=tmp;
                    break;
                }
            }
        }
        
        int l=index+1;
        int r=len-1;
            
        while(l<r){
            int tmp = nums[r];
            nums[r]=nums[l];
            nums[l]=tmp;
            r--;
            l++;
        }
    }
}

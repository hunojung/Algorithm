// https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int num : nums){
            if(num==0)continue;
            nums[index]=num;
            index++;
        }
        
        for(int i=index;i<nums.length;i++)
            nums[i]=0;
    }
}

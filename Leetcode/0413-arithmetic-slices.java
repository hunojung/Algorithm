// https://leetcode.com/problems/arithmetic-slices/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3)
            return 0;
        
        int diff = nums[1]-nums[0];
        int elements = 2;
        int subarrays = 0;
        
        for(int i = 2; i<nums.length;i++){
            
            int diff2 = nums[i]-nums[i-1];
            
            if(diff2==diff){
                elements++;
                
            }else{
                diff=diff2;
                elements=2;
            }
            
            if(elements>2)
                subarrays+=elements-2;
        }
        
        return subarrays;
    }
}

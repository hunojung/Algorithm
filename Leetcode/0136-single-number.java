// https://leetcode.com/problems/single-number/

// second submit
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res = res ^ nums[i];
        }
        return res;
    }
}


// first submit
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1)return nums[0];
        
        int res = 0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            if( i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }else{
                res = nums[i];
                break;
            }
        }
        return res;
    }
}

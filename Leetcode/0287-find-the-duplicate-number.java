// https://leetcode.com/problems/find-the-duplicate-number/
class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] used = new boolean[nums.length];
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(!used[nums[i]]){
                used[nums[i]]=true;
            }else{
                res = nums[i];
                break;
            }
        }
        return res;
    }
}

// first submit
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        for(int i=0;i<nums.length-1;i++)
            if(nums[i]==nums[i+1]){
                num = i;
                break;
            }
                
        return nums[num];
    }
}

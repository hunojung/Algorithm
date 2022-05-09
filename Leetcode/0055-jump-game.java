// https://leetcode.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
                
        int maxIdx = 0;
        
        for(int i=0;i<nums.length;i++){
            if(maxIdx<i) return false;

            maxIdx = Math.max(i+nums[i],maxIdx);
            
            if(maxIdx >= nums.length-1) return true;
        }
        return false;
    }
}

// https://leetcode.com/problems/rotate-array/
class Solution {
    public void rotate(int[] nums, int k) {
    	int[] rotated = new int[nums.length];
        
    	for (int i = 0; i < nums.length; i++) {
    		rotated[(i+k)%nums.length]=nums[i];
		}
        for (int i = 0; i < nums.length; i++) {
        	nums[i]=rotated[i];
		}
}

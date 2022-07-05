// https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        
        Arrays.sort(nums);
        int answer = 1, count = 1;
        for(int i = 1 ; i < nums.length ; i++){

            if(nums[i] == nums[i-1]+1){
                count++;
            }else if( nums[i] != nums[i-1] ){
                answer = Math.max(answer,count);
                count = 1;
            }
        }
        return Math.max(answer,count);
    }
}

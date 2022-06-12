// https://leetcode.com/problems/maximum-erasure-value/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] prefixSum = new int[nums.length+1];
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum[i+1] = prefixSum[i]+nums[i];
            
            if(map.containsKey(nums[i])){
                left = Math.max(left,map.get(nums[i])+1);
            }
            
            map.put(nums[i],i);
            max = Math.max(max,prefixSum[i+1]-prefixSum[left]);
        }
        
        return max;
    }
}

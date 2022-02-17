// https://leetcode.com/problems/majority-element/

// second submit
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, res = nums[0];
        for(int i=0;i<nums.length;i++){
            if(count==0)
                res=nums[i];
            
            if(res==nums[i])
                count++;
            else
                count--;
        }
        return res;
    }
}

// fitst submit
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>nums.length/2)return nums[i];
        }
        return 0;
    }
}

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] count = new int[nums.length+1];
        for(int num : nums)
            count[num]++;
        
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<nums.length+1;i++)
            if(count[i]==0)res.add(i);
            
        return res;
    }
}

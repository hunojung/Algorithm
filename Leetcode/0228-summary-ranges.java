// https://leetcode.com/problems/summary-ranges/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        StringBuilder input = new StringBuilder();
        
        for(int left=0;left<nums.length;left++){
            int right = left;
            
            while(right<nums.length-1 && nums[right]+1==nums[right+1]){
                right++;
            }
            
            if(left==right){
                input.append(nums[left]);
            }else{
                input.append(nums[left]).append("->").append(nums[right]);
            }
            answer.add(input.toString());
            input = new StringBuilder();
                
            left = right;
        }
        
        return answer;
    }
}

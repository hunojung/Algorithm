// https://leetcode.com/problems/product-of-array-except-self/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0]=1;
        answer[nums.length-1]=1;
        
        for(int i=0;i<nums.length-1;i++){
            answer[i+1] = answer[i]*nums[i];
        }
        
        int prefix = 1;
        for(int i=nums.length-1;i>0;i--){
            prefix = prefix*nums[i];
            answer[i-1] *= prefix;
        }
        return answer;
    }
}

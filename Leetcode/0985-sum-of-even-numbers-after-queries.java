// https://leetcode.com/problems/sum-of-even-numbers-after-queries/
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        int even_sum = 0;
        for(int num : nums) if(num%2==0) even_sum+= num;
        
        for(int i=0;i<queries.length;i++){
            if(nums[queries[i][1]]%2==0) even_sum -= nums[queries[i][1]];
            nums[queries[i][1]] += queries[i][0];
            if(nums[queries[i][1]]%2==0) even_sum += nums[queries[i][1]];
            
            answer[i] = even_sum;
        }
        return answer;
    }
}

// https://leetcode.com/problems/contiguous-array/
class Solution {
    public int findMaxLength(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int n = nums[i]==1?1:-1;
            sum=sum+n;
            
            if(map.get(sum)==null)
                map.put(sum,i);

            if(sum==0)
                answer = i+1;
            else
                answer=Math.max(answer,i-map.getOrDefault(sum,i));

        }
        return answer;
    }
}

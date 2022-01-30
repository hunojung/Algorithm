// https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/
class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int zeroCount=0;
        int oneCount=Arrays.stream(nums).sum();
    	int max=0;
    	
        for (int i = 0; i < nums.length+1; i++) {
        	int val = zeroCount+oneCount;
        	if(max<val){
        		answer = new ArrayList<>();
        		answer.add(i);
        		max = val;
        	}else if(max==val){
        		answer.add(i);
        	}
        	
        	if(i<nums.length){
        		zeroCount+=nums[i]^1;
        		oneCount-=nums[i];        		
        	}
		}
    	return answer;
    }
}

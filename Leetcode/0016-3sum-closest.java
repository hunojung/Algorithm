// https://leetcode.com/problems/3sum-closest/
class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        int answer = 10000000;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            // 제일 큰 값이 target보다 작으면 정답에 i 중 정답에 젤 가깝다
            int sum = nums[i]+nums[nums.length-1]+nums[nums.length-2];
            if(sum < target){
                answer = nums[i]+nums[nums.length-1]+nums[nums.length-2];
                continue;
            }
            
            // 제일 작은 값이 target보다 크면 정답에 i 중 젤 가깝다
            sum = nums[i]+nums[i+1]+nums[i+2];
            if(sum>target){
                if(Math.abs(target-answer)>Math.abs(target-sum)){
                    answer = sum;
                }
                break;
            }
            
            int left = i+1,right = nums.length-1;
            while(left<right){
                sum = nums[i]+nums[left]+nums[right];
                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else{
                    // break; 말고 return 하니까
                    // 22ms -> 6ms
                    return sum;
                }
            }
            
            if(Math.abs(target-answer)>Math.abs(target-sum)){
                answer = sum;
            }
        }
        
        return answer;
    }

}

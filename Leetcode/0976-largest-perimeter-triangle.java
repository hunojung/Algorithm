// https://leetcode.com/problems/largest-perimeter-triangle/
class Solution {
    public int largestPerimeter(int[] nums) {
        // 시간복잡도과 최악 n^2이라함
        // Arrays.sort(nums);
        swap(nums,nums.length-1);
        swap(nums,nums.length-2);
        swap(nums,nums.length-3);
        
        for(int i=nums.length-1;i>1;i--){
            //System.out.println(i);
            if(nums[i] < nums[i-1]+nums[i-2]){
                // 젤큰거 3개 체크되는 순간 끝.
                return nums[i]+nums[i-1]+nums[i-2];
                
            }else if(i>3){
                swap(nums,i-3);
            }
        }
        return 0;
    }
    
    public void swap(int[] nums, int idx){
        int max = nums[idx];
        int max_idx = idx;
        for(int i=0;i<idx;i++){
            if(max < nums[i]){
                max = nums[i];
                max_idx = i;
            }
        }
        int tmp = nums[idx];
        nums[idx] = nums[max_idx];
        nums[max_idx] = tmp;
    }
}

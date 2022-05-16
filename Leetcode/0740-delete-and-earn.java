// https://leetcode.com/problems/delete-and-earn/
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = 0;
        for(int n : nums)
            max = Math.max(max,n);
        
        int[] sum = new int[max+1];
        
        for(int n : nums)
            sum[n]+=n;
        
        for(int i=2;i<max+1;i++){
            sum[i] = Math.max(sum[i-2]+sum[i],sum[i-1]);
        }
        
        return sum[max];
    }
}

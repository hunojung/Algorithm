// https://leetcode.com/problems/triangle/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        
        for(int i = triangle.size()-1;i>-1;i--){
            List<Integer> now = triangle.get(i);
            
            for(int j=0;j<now.size();j++){
                dp[j] = now.get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        
        return dp[0];
    }
}

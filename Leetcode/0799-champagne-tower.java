// https://leetcode.com/problems/champagne-tower/
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[] dp = new double[query_row+1];
        dp[0]=poured;
        
        for(int i=0;i<query_row;i++)
            for(int j=i;j>-1;j--)
                dp[j+1] += dp[j] = Math.max((dp[j]-1)/2,0.0);
        
        return Math.min(dp[query_glass],1.0);
    }
}

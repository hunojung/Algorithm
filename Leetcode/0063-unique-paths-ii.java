// https://leetcode.com/problems/unique-paths-ii/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[1][0]=1;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(obstacleGrid[i-1][j-1]==1) continue;
                
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        
        return dp[m][n];
    }
}

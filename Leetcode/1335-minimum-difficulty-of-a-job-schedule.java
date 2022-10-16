// https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
class Solution {
    private int n;
    private int[] jobDifficulty;
    private Integer[][] dp;
    
    final int INF = 10001;
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length) return -1;
        
        n = jobDifficulty.length;
        this.jobDifficulty = jobDifficulty;
        dp = new Integer[n][d+1];
        
        int max = 0;
        for(int i=n-1;i>-1;i--){
            dp[i][1] = max = Math.max(max,jobDifficulty[i]);
        }
        
        return dp(0,d);
    }
    
    private int dp(int idx, int d){
        if(idx+d > n) return INF;
        
        if(dp[idx][d] != null) return dp[idx][d];
        
        int ans = INF;
        int max = 0;
        
        for(int i=idx; i+d<=n ;i++){
            max = Math.max(max,jobDifficulty[i]);
            ans = Math.min(ans,max + dp(i+1,d-1));    
        }
        
        return dp[idx][d] = ans;
    }
}

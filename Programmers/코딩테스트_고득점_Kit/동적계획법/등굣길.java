// https://school.programmers.co.kr/learn/courses/30/lessons/42898
class Solution {
    public int solution(int m, int n, int[][] puddles) {

        long[][] dp = new long[m+1][n+1];
        dp[0][1]=1;
        for(int[] puddle:puddles){
            dp[puddle[0]][puddle[1]] = -1;
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(dp[i][j]==-1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000007;
                }
            }
        }
        return (int)dp[m][n];
    }
}

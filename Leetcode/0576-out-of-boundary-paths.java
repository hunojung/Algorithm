// https://leetcode.com/problems/out-of-boundary-paths/
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int answer = 0;
        int mod = 1000000007;
        int[][][] dp = new int[m][n][maxMove+1];
        int[] dm = {0,1,0,-1};
        int[] dn = {1,0,-1,0};
        
        dp[startRow][startColumn][0] = 1;
        for(int i=0;i<maxMove;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<n;k++){
                    if(dp[j][k][i]==0) continue;
                    
                    // 4방향
                    for(int dir=0;dir<4;dir++){
                        int next_m = j+dm[dir];
                        int next_n = k+dn[dir];
                        
                        if(next_m<0||next_m==m||next_n<0||next_n==n){
                            //System.out.println(j+" "+k+" "+i);
                            answer = (answer+dp[j][k][i])%mod;
                        }else{
                            dp[next_m][next_n][i+1] = (dp[next_m][next_n][i+1]+dp[j][k][i])%mod; 
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}

// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
import java.util.*;
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[][] dp = new int[m+1][m+1];
                
        for(int i=m-1;i>=0;i--){
            for(int l=i;l>=0;l--){
                int r = n-1-(i-l);
                //System.out.println(l+" "+r);
                
                int scoreR = multipliers[i]*nums[r] + dp[i+1][l];
                int scoreL = multipliers[i]*nums[l] + dp[i+1][l+1];
                
                dp[i][l] = Math.max(scoreR,scoreL);
            }
        }

        return dp[0][0];
    }
}

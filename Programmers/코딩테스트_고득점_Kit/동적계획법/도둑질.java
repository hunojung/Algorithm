class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        // 첫번째집 포함, 미포함
        int[][] dp = new int[money.length][2];
        dp[0][0] = money[0];
        dp[1][0] = Math.max(dp[0][0],money[1]);
        
        dp[1][1] = money[1];
        
        for(int i=2;i<money.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-2][0]+money[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][1]+money[i]);
        }
        
        // 첫째집 포함은 마지막집 한칸 앞에서 최댓값 비교
        return Math.max(dp[money.length-2][0],dp[money.length-1][1]);
    }
}

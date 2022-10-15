// 진짜 개어렵다 ;.에휴
// https://leetcode.com/problems/string-compression-ii/
class Solution {
    
    int n;
    Integer[][] dp;
    char[] chars;
    public int getLengthOfOptimalCompression(String s, int k) {
        n = s.length();
        dp = new Integer[n][k+1];
        chars = s.toCharArray();
        
        return dp(0,k);
    }
    
    public int dp(int idx, int k){
        // 최댓값
        if(k<0) return n;

        // 현재부터 뒷부분 다 삭제 가능할 경우 0
        if(n <= idx+k) return 0;
        
        // 현재 인덱스 k개 방문한적 있을경우
        if(dp[idx][k] != null) return dp[idx][k];
        
        // 현재 인덱스 건너뛴거 바로 체크
        dp[idx][k] = dp(idx+1,k-1);
        
        int same = 0, diff = 0, len = 0;
        
        // 처음 들어온 인덱스부터 해서 다른부분 다 지우고 넘어가봄
        // aabbcc 인 경우 a~c로 됐을때 어차피 bb 지우고
        // cc만 검토한 길이랑 자동으로 비교 됨
        for(int i = idx; i<n && diff <= k ; i++){
            if(chars[i] == chars[idx]){
                same++;
                if(same ==1 || same ==2 || same == 10 || same == 100)
                    len++;
            }else{
                diff++;
            }
            
            dp[idx][k] = Math.min(dp[idx][k], len + dp(i+1,k-diff));
        }
        return dp[idx][k];
    }
}

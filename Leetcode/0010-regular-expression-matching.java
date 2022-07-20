// https://leetcode.com/problems/regular-expression-matching/
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0) return s.length()==0;
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int j=2;j<=p.length();j++){
            dp[0][j] = p.charAt(j-1)=='*' && dp[0][j-2];
        }
        
        for(int j=1;j<=p.length();j++){
            for(int i=1;i<=s.length();i++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')) && dp[i-1][j];
                        
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}

// first submit
class Solution {
    public boolean isMatch(String t, String p) {
          if(p.isEmpty()) return t.isEmpty();
        boolean firstMatch = !t.isEmpty() && (t.charAt(0)== p.charAt(0) || p.charAt(0)== '.');
        if(p.length()>=2 && p.charAt(1) == '*')
        {
            return isMatch(t, p.substring(2)) || firstMatch&& isMatch(t.substring(1),p);
        }else{
            return firstMatch && isMatch(t.substring(1),p.substring(1));
        }
        
    }
}

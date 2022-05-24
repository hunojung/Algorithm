// https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];    
            }
        }
        
        return dp[n];
    }
}

class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        
        if(n==1 || n==0) return 1;
        
        if(map.containsKey(n)) return map.get(n);
        
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += numTrees(i-1)*numTrees(n-i);
        }
        
        map.put(n,sum);
        return sum;
    }
}

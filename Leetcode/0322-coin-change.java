// https://leetcode.com/problems/coin-change/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,10001);
        dp[0]=0;
        
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        
        if(dp[amount]==10001) return -1;
        
        return dp[amount];
    }
}


// 첫제출
class Solution {
    public int coinChange(int[] coins, int amount) {
        int answer = 0;
        
        Arrays.sort(coins);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[amount+1];
        
        q.add(0);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            //print
            //System.out.println(answer+"회");
            
            for(int i=0;i<size;i++){
                int now = q.poll();
                
                //print
                //System.out.print(now+" ");
                if(now==amount){
                    return answer;
                }
                
                for(int j=0;j<coins.length;j++){
                    int next = now+coins[j];
                    if(coins[j]>amount || next>amount) break;
                    
                    if(visited[next]) continue;
                    
                    q.add(next);
                    visited[next] = true;
                }
            }
            answer++;
            //print
            //System.out.println("");
        }
        
        return -1;
    }
}

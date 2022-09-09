import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        // [이긴 선수][진 선수]
        boolean[][] winner = new boolean[n+1][n+1];
        for(int[] result : results){
            winner[result[0]][result[1]] = true;
        }
        
        for(int i=1;i<n+1;i++){
            int count = count_player(winner,i,true);
            count += count_player(winner,i,false);
            
            if(count==n-1) answer++;
        }

        return answer;
    }
    public int count_player(boolean[][] winner, int n,boolean win){
        int count = -1;
        boolean[] counted = new boolean[winner.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        counted[n] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            count++;
            
            for(int i=1;i<winner.length;i++){
                if(win){
                    if(!counted[i] && winner[now][i]){
                        counted[i] = true;
                        q.add(i);
                    }
                }else{
                    if(!counted[i] && winner[i][now]){
                        counted[i] = true;
                        q.add(i);
                    }                    
                }
            }
        }
        return count;
    }
}

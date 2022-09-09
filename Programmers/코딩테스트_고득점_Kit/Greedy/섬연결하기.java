import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n+1];
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        for(int i=1;i<=n;i++){
            parent[i] = i;
        } 
        
        for(int[] cost : costs){
            int a_parent = find(parent,cost[0]);
            int b_parent = find(parent,cost[1]);
            
            //System.out.println(a_parent+" "+b_parent);
            
            if(a_parent != b_parent){
                parent[b_parent] = a_parent;
                answer+=cost[2];
            }
        }
        
        return answer;
    }
    
    public int find(int[] parent,int a){
        if(parent[a] == a){
            return a;
        }
        return find(parent,parent[a]);
    }
}

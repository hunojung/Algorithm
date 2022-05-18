// https://leetcode.com/problems/critical-connections-in-a-network/
class Solution {
    List<List<Integer>> answer;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        answer = new ArrayList<>();
        time = 0;
        
        boolean[] used = new boolean[n];
        int[] times = new int[n];
        
        List<Integer>[] servers = new ArrayList[n];
        for(int i=0;i<n;i++){
            servers[i] = new ArrayList<>();
        }
        
        for(int i=0;i<connections.size();i++){
            List<Integer> server = connections.get(i);
            int a = server.get(0);
            int b = server.get(1);
            servers[a].add(b);
            servers[b].add(a);
        }
        
        dfs( servers, used, times, 0, -1);
        
        return answer;
    }
    
    private void dfs(List<Integer>[] servers, boolean[] used, int[] times, int now, int before){
        
        used[now] = true;
        times[now] = time++;
        int current = times[now];

        for(int i=0;i<servers[now].size();i++){
            int next = servers[now].get(i);
            // 바로 직전에서 온거는 건너뛰기
            if(next == before) continue;
            
            if(!used[next]){
                dfs( servers, used, times, next, now);
            }
            
            // next가 더 작으면 그쪽길로해서 온걸로 침?
            times[now] = Math.min(times[now],times[next]);
         
            if(current < times[next]){
                answer.add(Arrays.asList(now,next));
            }   
        }
    }
}

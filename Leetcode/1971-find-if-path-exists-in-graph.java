// https://leetcode.com/problems/find-if-path-exists-in-graph/
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)
            return true;

        int[] u = new int[n];
        for(int i=0;i<n;i++)
            u[i]=i;
        
        for(int i=0;i<edges.length;i++){
            int a = find(u,edges[i][0]);
            int b = find(u,edges[i][1]);
            if(a!=b) u[a]=b;
            //System.out.println(edges[i][0] +" "+ a +" / "+edges[i][1]+" "+b);
        }

        return find(u,u[source])==find(u,u[destination]);
    }
    
    public int find(int[] u,int n){
        if(u[n]==n) return n;
        return u[n] = find(u,u[n]);
    }
}

// first submit
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        
        List<Integer>[] list = new ArrayList[n];
        for(int i=0;i<n;i++)
            list[i] = new ArrayList<>();
        
        for(int i=0;i<edges.length;i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source]=true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            if(now==destination)
                return true;
            
            for(int i=0;i<list[now].size();i++){
                int next = list[now].get(i);
                if(visited[next]) continue;
                
                q.add(next);
                visited[next]=true;
            }
        }
        return false;
    }
}

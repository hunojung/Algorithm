// https://leetcode.com/problems/max-area-of-island/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visited = new boolean[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(visited[i][j] || grid[i][j]==0) continue;
                
                // System.out.println(i+" "+j);
                int size = bfs(grid,i,j,visited);
                answer = Math.max(answer,size);
                // System.out.println(size+" "+answer);
            }
        }
        
        return answer;
    }
    
    public int bfs(int[][] grid,int i,int j,boolean[][] visited){
        int size = 0;
        int h = grid.length;
        int w = grid[0].length;
        int[] dh = {0,1,0,-1};
        int[] dw = {1,0,-1,0};
        
        Queue<int[]> q = new LinkedList<>();
        visited[i][j]=true;
        q.add(new int[] {i,j});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            size++;
            
            for(int idx=0;idx<4;idx++){
                int nh = now[0]+dh[idx];
                int nw = now[1]+dw[idx];
                if(nh>-1 && nh<h && nw>-1 && nw<w && !visited[nh][nw] && grid[nh][nw]==1){
                    visited[nh][nw]=true;
                    q.add(new int[] {nh,nw});
                }
            }
            
        }
        return size;
    }
}

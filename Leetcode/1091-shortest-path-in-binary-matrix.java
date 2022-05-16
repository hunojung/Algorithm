// https://leetcode.com/problems/shortest-path-in-binary-matrix/
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        
        Queue<int[]> q = new LinkedList<>();
        grid[0][0]=1;
        
        q.add(new int[] {0,0});
        
        int[][] idx = {{-1,-1,-1,0,1,1,1,0},{-1,0,1,1,1,0,-1,-1}};
        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[0]==n-1 && now[1]==n-1) break;

            for(int j=0;j<8;j++){
                int dh = now[0]+idx[0][j];
                int dw = now[1]+idx[1][j];

                if(dh>-1 && dh<n && dw>-1 && dw<n && grid[dh][dw]==0){
                    grid[dh][dw]=grid[now[0]][now[1]]+1;
                    q.add(new int[] {dh,dw});
                }
            }
        }
        
        if(grid[n-1][n-1]==0) return -1;
        
        return grid[n-1][n-1];
    }
}

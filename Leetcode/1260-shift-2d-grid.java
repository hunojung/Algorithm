// https://leetcode.com/problems/shift-2d-grid/
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //List<List<Integer>> res = new ArrayList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        k %= (m*n);
        
        int[][] idx = new int[2][2];
        idx[0][0] = 0; idx[0][1] = 0;
        idx[1][0]  =k/n; idx[1][1] = k%n;
        
        int[][] dummy = new int[m][n];
        for(int i=0;i<m*n;i++){
            dummy[idx[1][0]][idx[1][1]]=grid[idx[0][0]][idx[0][1]];
            //System.out.println(idx[0][0]+" "+idx[0][1]+" "+dummy[idx[1][0]][idx[1][1]]);
            plus_idx(idx,m,n);
        }
        
        // for(int i=0;i<m;i++){
        //     List<Integer> list = new ArrayList<>();
        //     for(int j=0;j<n;j++){
        //         list.add(dummy[i][j]);
        //     }
        //     res.add(new ArrayList(list));
        // }
        
        return (List)Arrays.asList(dummy);
    }
    
    public void plus_idx(int[][] idx,int m,int n){
        idx[0][1]++;
        if(idx[0][1]==n){
            idx[0][1]=0;
            idx[0][0]=idx[0][0]+1==m?0:idx[0][0]+1;
        }
        idx[1][1]++;
        if(idx[1][1]==n){
            idx[1][1]=0;
            idx[1][0]=idx[1][0]+1==m?0:idx[1][0]+1;
        }
    }
}

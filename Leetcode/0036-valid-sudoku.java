// https://leetcode.com/problems/valid-sudoku/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] idxs = {{0,0},{3,0},{6,0},{0,3},{0,6},{3,3},{3,6},{6,3},{6,6}};
        
        //System.out.println("test1 start");
        for(int[] idx : idxs){
            boolean[] check = new boolean[10];
            
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    
                    int h = idx[0]+i;
                    int w = idx[1]+j;
                    if(board[h][w]=='.') continue;
                    
                    int num = board[h][w]-'0';
                    if(check[num]) return false;
                    check[num]=true;
                }
            }
        }
        
        //System.out.println("test2 start");
        
        for(int i=0;i<9;i++){
            boolean[] check1 = new boolean[10];
            boolean[] check2 = new boolean[10];
            for(int j=0;j<9;j++){
                //System.out.println(i+" "+j);
                if(board[i][j]!='.'){
                    int num1 = board[i][j]-'0';
                    if(check1[num1]) return false;
                    check1[num1]=true;
                }
                
                if(board[j][i]!='.'){
                    int num2 = board[j][i]-'0';
                    if(check2[num2]) return false;
                    check2[num2]=true;
                }
            }
        }
        
        return true;
    }
}

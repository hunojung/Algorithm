// https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        // search row
        int row = -1;
        for(row=0;row<row_len-1;row++){
                        
            if(matrix[row][0]<=target && matrix[row+1][0]>target){
                break;
            }
        }
        
        // search col
        for(int i=0;i<col_len;i++){
            if(matrix[row][i]==target){
                return true;
            }else if(matrix[row][i]>target){
                return false;
            }
        }
        
        return false;
    }
}

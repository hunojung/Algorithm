// https://leetcode.com/problems/range-sum-query-2d-immutable/
class NumMatrix {
    int[][] arr;

    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length+1][matrix[0].length+1];
        
        for(int i=0;i<matrix.length;i++){
            int rowsum = 0;
            for(int j=0;j<matrix[0].length;j++){
                rowsum += matrix[i][j];
                arr[i+1][j+1] = arr[i][j+1]+rowsum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        return arr[row2+1][col2+1]-arr[row2+1][col1]-arr[row1][col2+1]+arr[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */



// first submit
class NumMatrix {
    private int[][] arr;

    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length][matrix[0].length+1];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                arr[i][j+1] = arr[i][j]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            sum += (arr[i][col2+1]-arr[i][col1]);
        }
        return sum;
    }
}

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        
        while(left <= right){
            int mid = right - (right - left) / 2;
            if( checkNumberPosition(matrix,mid,n) >= k ){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    int checkNumberPosition(int[][] matrix, int checkNum, int n){
        int count = 0;
        
        for(int h = 0 ; h < n; h++){
            int left = 0;
            int right = n-1;
            
            while(left <= right){
                int mid = right - (right - left) / 2;
                if( checkNum >= matrix[h][mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            count += left;
        }
      
        return count;
    }
}


// first submit
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] nums = new int[n*n];
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nums[idx++] = matrix[i][j];
            }
        }
        
        Arrays.sort(nums);
        return nums[k-1];
    }
}

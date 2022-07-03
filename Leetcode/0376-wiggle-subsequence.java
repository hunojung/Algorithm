// https://leetcode.com/problems/wiggle-subsequence/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[nums.length][2];
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]){
                arr[i][0] = arr[i-1][1] + 1;
                arr[i][1] = arr[i-1][1];
            }else if(nums[i-1]>nums[i]){
                arr[i][0] = arr[i-1][0];
                arr[i][1] = arr[i-1][0] + 1;
            }else{
                arr[i][0] = arr[i-1][0];
                arr[i][1] = arr[i-1][1];
            }
        }
        return Math.max(arr[n-1][0],arr[n-1][1])+1;
    }
}


// first submit
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[nums.length][2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j])
                    arr[j][0] = Math.max( arr[j][0], arr[i][1] +1);
                else if(nums[i]>nums[j])
                    arr[j][1] = Math.max( arr[j][1], arr[i][0] +1);
                else{
                    arr[j][0] = Math.max( arr[j][0], arr[i][0] );
                    arr[j][1] = Math.max( arr[j][1], arr[i][1] );
                }
            }
        }
        return Math.max(arr[n-1][0],arr[n-1][1])+1;
    }
}

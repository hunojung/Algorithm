// https://leetcode.com/problems/spiral-matrix-ii/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int status = 0, h = 0, w = 0;
        
        int num = 1;
        while(num<n*n+1){
            arr[h][w] = num;
            
            if(status==0){
                if(w<n-1 && arr[h][w+1] == 0){
                    w++;
                }else{
                    status++;
                    h++;
                }
            }else if(status==1){
                if(h<n-1 && arr[h+1][w] == 0){
                    h++;
                }else{
                    status++;
                    w--;
                }
            }else if(status==2){
                if(w>0 && arr[h][w-1] == 0){
                    w--;
                }else{
                    status++;
                    h--;
                }
            }else{
                if(h>0 && arr[h-1][w] == 0){
                    h--;
                }else{
                    status=0;
                    w++;
                }
            }
            
            num++;
        }
        return arr;
    }
}

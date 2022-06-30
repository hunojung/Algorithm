import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(check[i][j] || picture[i][j]==0) continue;
                
                numberOfArea += 1;
                int checkedArea = areaCheck(m,n,i,j,picture,check);
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea,checkedArea);
                
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int areaCheck(int m,int n,int n1,int n2,int[][] picture,boolean[][] check){
        int area = 0;
        int num = picture[n1][n2];
        int[] dm = {0,1,0,-1};
        int[] dn = {1,0,-1,0};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {n1,n2});
        check[n1][n2] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            // System.out.println(now[0]+" "+now[1]);
            area++;
            for(int i=0;i<4;i++){
                int nextM = now[0]+dm[i];
                int nextN = now[1]+dn[i];
                if(nextM>-1 && nextM<m &&nextN>-1 && nextN<n){
                    if(picture[nextM][nextN]==num && check[nextM][nextN]==false){
                        q.add(new int[] {nextM,nextN});
                        check[nextM][nextN]=true;
                    }
                }
            }
        }
        // System.out.println();
        return area;
    }
}

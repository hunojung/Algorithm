// https://leetcode.com/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        
        List<Integer> answer = new ArrayList<>();
        boolean[][] used = new boolean[h][w];
        
        Queue<int[]> q = new LinkedList<>();
        // x, y, status(0~3)
        if(w == 1 ) {
            q.add(new int[] {0,0,1});
        }else{
            q.add(new int[] {0,0,0});    
        }
        
        used[0][0]=true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            answer.add(matrix[now[0]][now[1]]);
            
            // 오른쪽
            if(now[2]==0){
                if(now[1]<w-1 && !used[now[0]][now[1]+1]){
                    used[now[0]][now[1]+1]=true;
                    q.add(new int[] {now[0],now[1]+1,now[2]});
                }else{
                    if(now[0]<h-1 && !used[now[0]+1][now[1]]){
                        used[now[0]+1][now[1]]=true;
                        q.add(new int[] {now[0]+1,now[1],1});
                    }
                }
                
            // 아래
            }else if(now[2]==1){
                if(now[0]<h-1 && !used[now[0]+1][now[1]]){
                    used[now[0]+1][now[1]]=true;
                    q.add(new int[] {now[0]+1,now[1],now[2]});
                }else{
                    if(now[1]>0 && !used[now[0]][now[1]-1]){
                        used[now[0]][now[1]-1]=true;
                        q.add(new int[] {now[0],now[1]-1,2});
                    }
                }
                
            // 왼쪽
            }else if(now[2]==2){
                if(now[1]>0 && !used[now[0]][now[1]-1]){
                    used[now[0]][now[1]-1]=true;
                    q.add(new int[] {now[0],now[1]-1,now[2]});
                }else{
                    if(now[0]>0 && !used[now[0]-1][now[1]]){
                        used[now[0]-1][now[1]]=true;
                        q.add(new int[] {now[0]-1,now[1],3});
                    }
                }
            
            // 위
            }else{
                if(now[0]>0 && !used[now[0]-1][now[1]]){
                    used[now[0]-1][now[1]]=true;
                    q.add(new int[] {now[0]-1,now[1],now[2]});
                }else{
                    if(now[1]<w-1 && !used[now[0]][now[1]+1]){
                        used[now[0]][now[1]+1]=true;
                        q.add(new int[] {now[0],now[1]+1,0});
                    }
                }
            }
        }        
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/87694
import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 0 - out , 1 - line , 2 - in
        int[][] check_map = new int[101][101];
        
        check_map_setting(check_map,rectangle);
        
        int answer = dfs(check_map,characterX*2, characterY*2, itemX*2,itemY*2);
        
        return answer/2;
    }
    
    public int dfs(int[][] check_map,int x,int y,int ix, int iy){
        int length = 0;
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y,0});
        check_map[x][y] = 2;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            //System.out.println(now[0]+" "+now[1]+" "+now[2]);
            if(now[0]==ix && now[1]==iy){
                length = now[2];
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx>0 && nx<101 && ny>0 && ny<101 && check_map[nx][ny]==1){
                    check_map[nx][ny]=2;
                    q.add(new int[] {nx,ny,now[2]+1});
                }
            }
        }
        
        return length;
    }
    
    // 1 - 라인, 교차로, 2 - 내부칸
    // 1칸 너비짜리 사각형 내부가 없어서 통과됨;;
    // 내부 만드려고 좌표 * 2 함
    public void check_map_setting(int[][] check_map, int[][] rectangle){
        for(int[] rec : rectangle){
            
            for(int j=rec[0]*2;j<=rec[2]*2;j++){
                for(int k=rec[1]*2;k<=rec[3]*2;k++){
                    if(check_map[j][k] < 2 && 
                       (j==rec[0]*2 || j==rec[2]*2 || k==rec[1]*2 || k==rec[3]*2)){
                        check_map[j][k]=1;
                    }else{
                        check_map[j][k]=2;
                    }
                }
            }
        }
    }
}

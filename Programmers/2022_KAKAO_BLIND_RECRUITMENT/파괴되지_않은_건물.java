// https://programmers.co.kr/learn/courses/30/lessons/92344
class Solution {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map = new int[board.length][board[0].length+1];
        
        int add = 0;
        for(int[] s : skill){
            add = s[5];
            if(s[0]==1) add = add*-1;
            for(int i = s[1];i<s[3]+1;i++){
                map[i][s[2]]+=add;
                map[i][s[4]+1]-=add;
            }
        }
        
        for(int i = 0 ; i<board.length; i++){
            add = 0;
            for(int j=0; j<board[0].length; j++){
                add+=map[i][j];
                board[i][j]+=add;
                //System.out.print(board[i][j]+" ");
                if(board[i][j]>0)answer++;
            }//System.out.println("");
        }
        return answer;
    }
}

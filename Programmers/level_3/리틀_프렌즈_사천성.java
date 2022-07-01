import java.util.*;
class Solution {
    Queue<Character> answer_q;//정답 담을 큐
    int[][] alpha;//알파벳 좌표
    boolean[] alpha_exist;//알파벳 존재유무
    char[][] chars;
    int h,w;
    public String solution(int m, int n, String[] board) {
        // 변수들 선언
        answer_q = new LinkedList<>();
        h = board.length;
        w = board[0].length();
        StringBuilder answer = new StringBuilder();
        chars = new char[h][w];
        alpha = new int[26][2];
        alpha_exist = new boolean[26];
        
        // 단어행렬구현
        for(int i=0;i<h;i++){
            chars[i] = board[i].toCharArray();
        }
        
        // 알파벳 체크 & 좌표 입력
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(chars[i][j]>='A' && chars[i][j]<='Z'){
                    alpha_exist[chars[i][j]-'A']=true;
                    alpha[chars[i][j]-'A'][0]=i;
                    alpha[chars[i][j]-'A'][1]=j;
                }
            }
        }
        
        // 정답찾기
        if(!search(chars)) return "IMPOSSIBLE";
        
        // 정답리턴        
        while(!answer_q.isEmpty()) answer.append(answer_q.poll());
        return answer.toString();
    }
    
    private boolean search(char[][] chars){
        // for문에서 continue 26번하면 다 찾은거
        int count = 0;
        for(int i=0;i<26;i++){
            if(alpha_exist[i]==false){
                count++;
                continue;
            } 
            
            int[] num = alpha[i];
            
            if(bfs(chars,num)){
                // 찾은 알파벳
                //System.out.println("찾음 : "+(char)('A'+i)+" "+num[0]+" "+num[1]);
                answer_q.add((char)('A'+i));
                alpha_exist[i]=false;
                return search(chars);
            }
        }
        System.out.println("count :"+count);
        if(count==26) return true;
        return false;
    }
    
    private boolean bfs(char[][] chars,int[] num){
        //System.out.println("bfs들어옴 : "+chars[num[0]][num[1]]+" "+num[0]+" "+num[1]);
        // 순서가 오,아,왼,위
        int[] dh = {0,1,0,-1};
        int[] dw = {1,0,-1,0};
        
        // 체크를 각 방향으로 접근한걸 모두 체크
        boolean[][][] checked = new boolean[h][w][4];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(num[0],num[1],-1,false));
        checked[num[0]][num[1]][0] = true;
        checked[num[0]][num[1]][1] = true;
        checked[num[0]][num[1]][2] = true;
        checked[num[0]][num[1]][3] = true;
        
        while(!q.isEmpty()){
            Point now = q.poll();
           
            for(int i=0;i<4;i++){
                int nh = now.h+dh[i];
                int nw = now.w+dw[i];
                if(nh>-1 && nh<h && nw>-1 && nw<w && !checked[nh][nw][i]){
                    // 정답일 경우 
                    if(chars[num[0]][num[1]] == chars[nh][nw]){
                        // 방향전환 0번이거나 방향전환 1번에 방향 같음
                        if(now.turn==false || (now.turn==true && now.direction==i)){
                            //빈칸으로 만들고 true 리턴
                            chars[num[0]][num[1]] = '.';
                            chars[nh][nw] = '.';
                            return true;
                        }
                    }
                    
                    // 빈칸일경우 진행
                    if(chars[nh][nw]=='.'){
                        // 같은 방향이거나 초기값이면 그냥 넣기
                        if(now.direction==-1 || now.direction==i){
                            checked[nh][nw][i]=true;
                            q.add(new Point(nh,nw,i,now.turn));
                            
                        // 꺽은적 없어야 꺽기가능
                        }else if(now.turn==false){
                            checked[nh][nw][i]=true;
                            q.add(new Point(nh,nw,i,true));
                        }
                    }
                }
            }
        }
        
        return false;
    }
}

class Point{
    int h;
    int w;
    int direction;
    boolean turn;
    public Point(int h,int w,int direction,boolean turn){
        this.h = h;
        this.w = w;
        this.direction = direction;
        this.turn = turn;
    }
}

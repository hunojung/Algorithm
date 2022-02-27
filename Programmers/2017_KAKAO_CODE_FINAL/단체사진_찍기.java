import java.util.*;
class Solution {
	
    private int answer;
    public int solution(int n, String[] data) {
        answer=0;
        // true면 못가는곳
        boolean[][][] no = new boolean[8][8][8];
        
        Map<Character,Integer> map = new HashMap<>();
        char[] friends = {'A','C','F','J','M','N','R','T'};
        for (int i = 0; i < 8; i++) {
			map.put(friends[i], i);
		}
        
        for(String s : data){
            int f1 = map.get(s.charAt(0));
            int f2 = map.get(s.charAt(2));
            char comp = s.charAt(3);
            int num = s.charAt(4)-'0';
            
            // 친구1,친구2,거리별 세팅
            // true면 해당 거리에 친구 못옴
            for(int i=0;i<8;i++){
                if(comp=='='){
                    if(i!=num){
                    	no[f1][f2][i]=true;
                    	no[f2][f1][i]=true;
                    }
                }else if(comp=='<'){
                     if(i>=num){
                        no[f1][f2][i]=true;
                        no[f2][f1][i]=true;
                    }
                }else{
                    if(i<=num){
                        no[f1][f2][i]=true;
                        no[f2][f1][i]=true;
                    }
                }
            }
        }
        int[] position = new int[8];
        boolean[] use = new boolean[8];
        back(no,position,use,0);

        return answer;
    }
    
    public void back(boolean[][][] no,int[] position,boolean[] use,int pos){
        if(pos==8){
            answer++;
            return;
        }
        
        // 친구
        for(int i = 0 ; i< 8 ; i++){
        	if(use[i]) continue;
            // 비교할 친구들 앞에 위치
            // ok true면 i친구가 pos 위치에 올 수 있음
        	boolean ok = true;
            for(int j=0;j<pos;j++){
                if(no[i][position[j]][pos-j-1]){
                    ok = false;
                    break;
            	}
            }
            
            if(ok){
            	position[pos]=i;
            	use[i]=true;
            	back(no,position,use,pos+1);
            	use[i]=false;
            }
        }
    }
}

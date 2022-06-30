import java.util.Set;
import java.util.HashSet;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_count = 0;
        int correct_count = 0;
        
        Set<Integer> wins = new HashSet<Integer>();
        for(int n : win_nums) wins.add(n);
        
        for(int n:lottos){
            if(n==0) zero_count++;
            else if(wins.contains(n)) correct_count++;
        }
        
        int max = correct_count+zero_count;
        int min = correct_count;
        answer[0] = check_win(max);
        answer[1] = check_win(min);
            
        return answer;
    }
    
    private int check_win(int num){
        switch (num){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6; 
        }
    }
}

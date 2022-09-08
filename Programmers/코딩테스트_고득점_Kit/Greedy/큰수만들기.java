// 첫 풀이
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
         
        int before_max_idx = -1;
        for(int i=k;i<number.length();i++){
            char max_num = number.charAt(before_max_idx+1);
            int idx = before_max_idx+1;
            for(int j=before_max_idx+1;j<=i;j++){
                if(max_num < number.charAt(j)){
                    max_num = number.charAt(j);
                    idx = j;
                }
                
                if(max_num == '9') break;
            }
            before_max_idx = idx;
            sb.append(max_num);
        }
        
        return sb.toString();
    }
}

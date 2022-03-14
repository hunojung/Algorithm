// https://leetcode.com/problems/simplify-path/
import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        StringTokenizer st = new StringTokenizer(path,"/");
        Deque<String> dq = new ArrayDeque<>();
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            
            if(s.equals("..")){
                if(!dq.isEmpty()) dq.pollLast();
                
                continue;
            }
            
            if(s.equals(".")){
                continue;
            }
            
            dq.add(s);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!dq.isEmpty())
            sb.append("/").append(dq.pollFirst());
        
        if(sb.length()<1)
            sb.append("/");
        
        return sb.toString();
    }
}

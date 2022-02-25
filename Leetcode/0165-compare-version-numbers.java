// https://leetcode.com/problems/compare-version-numbers/
import java.util.*;
class Solution {
    public int compareVersion(String version1, String version2) {
        StringTokenizer st1 = new StringTokenizer(version1,".");
        StringTokenizer st2 = new StringTokenizer(version2,".");
        int res = 0, num1, num2;
        
        while(res==0 && ( st1.hasMoreTokens() || st2.hasMoreTokens())) {
         
            num1 = 0;
            if(st1.hasMoreTokens())
                num1 = Integer.parseInt(st1.nextToken());
            
            num2 = 0;
            if(st2.hasMoreTokens())
                num2 = Integer.parseInt(st2.nextToken());
            
            if(num1>num2)
                res=1;
            
            if(num1<num2)
                res=-1;
            
        }
        
        return res;
    }
}

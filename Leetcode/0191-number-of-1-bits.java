// https://leetcode.com/problems/number-of-1-bits/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int one = 0;
        
        while(n!=0){
            one += (n & 1);            
            n>>>=1; // unsigned int shift
        }
        
        return one;
    }
}


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int count = 0;
        
        //System.out.println("n : "+n);
        if(n<0){
            count++;
            n = Integer.MAX_VALUE+(n+1);
        }
        
        while(n>0){
            //System.out.println(n+" "+count);
            if(n%2==1) count++;
            n/=2;
        }
        return count;
    }
}

// https://leetcode.com/problems/mirror-reflection/
class Solution {
    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p,q);
        int lcm = p*q/gcd;

        if((lcm / p)%2 == 1){
            if((lcm / q)%2 == 1){
                return 1;
            }else{
                return 2;
            }
        }
        return 0;
    }
    
    int gcd(int p, int q){
        while(q!=0){
            int r = p % q;
            p = q;
            q = r;
        }
        return p;
    }
}

class Solution {
    public long solution(int w, int h) {
        
        int gcd = gcd(w,h);
        
        return (long)w*(long)h-(long)gcd*(h/gcd+w/gcd-1);
    }
    
    private int gcd(int a , int b){
        if(b>a) return gcd(b,a);
        if(b==0) return a;
        return gcd(b,a%b);
    }
}

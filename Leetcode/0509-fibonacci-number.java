// https://leetcode.com/problems/fibonacci-number/
class Solution {
    private int[] f;
    public int fib(int n) {
        if(n<2) return n;
        
        f = new int[n+1];
        f[1] = 1;
        
        return fibonacci(n);
    }
    
    private int fibonacci(int n){
        if(n<2) return n;
        
        if(f[n]>0) return f[n];
        
        return f[n] = fibonacci(n-1)+fibonacci(n-2);
    }
}

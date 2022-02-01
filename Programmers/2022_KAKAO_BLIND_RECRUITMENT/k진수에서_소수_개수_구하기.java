// https://programmers.co.kr/learn/courses/30/lessons/92335
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] num = Integer.toString(n,k).split("0+");
        for(String s : num){
            // 다음 숫자
            if(isPrime(s))answer++;
        }
        return answer;
    }
    
    public boolean isPrime(String n){
        Long num = Long.parseLong(n);
        
        if(num==1 || num==4)
            return false;
        else if(num==2 || num==3)
            return true;
        
        for(long i = 2 ; i*i<=num ; i++ )
            if(num%i==0)
                return false;
        return true;
    }
}

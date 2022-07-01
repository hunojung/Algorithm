class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n>0){
            if(n%3==0){
                answer.append('4');
            }else if(n%3==2){
                answer.append('2');
            }else{
                answer.append('1');
            }
            n = (n-1)/3;
        }
        return answer.reverse().toString();
    }
}

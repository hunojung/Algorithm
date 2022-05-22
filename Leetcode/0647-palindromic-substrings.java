// https://leetcode.com/problems/palindromic-substrings/
class Solution {
    private int answer;
    public int countSubstrings(String s) {
        answer = 0;
        
        for(int i = 0;i<s.length();i++){
            isPalindrome(s,i,i);
            isPalindrome(s,i,i+1);
        }
        
        return answer;
    }
    
    private void isPalindrome(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            answer++;
            left--;
            right++;
        }
    }
}

// 첫 제출
class Solution {
    public int countSubstrings(String s) {
        int answer = s.length();
        for(int i = 2;i<=s.length();i++){
            for(int j=0;j+i<=s.length();j++){
                if(isPalindrome(s.substring(j,j+i))){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    private boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)==s.charAt(s.length()-1-i)) continue;
            return false;
        }
        return true;
    }
}

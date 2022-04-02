// https://leetcode.com/problems/valid-palindrome-ii/
class Solution {
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                if(isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1))
                    return true;
                return false;
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}

// https://leetcode.com/problems/remove-palindromic-subsequences/
class Solution {
    public int removePalindromeSub(String s) {
        
        int l = 0, r = s.length()-1;
        
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return 2;
            l++;
            r--;
        }
        
        return 1;
    }
}

// https://leetcode.com/problems/palindrome-number/
class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0)return false;
    	
    	int palindrome = 0;
    	int original = x;
        while(x>0) {	
        	palindrome = palindrome*10+x%10;
        	x/=10;
        }
        if(palindrome == original)return true;
        return false;
    }
}

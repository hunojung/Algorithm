// https://leetcode.com/problems/find-the-difference/
class Solution {
    public char findTheDifference(String s, String t) {
        int answer = t.charAt(s.length());
        for(int i=0;i<s.length();i++){
        	answer += (t.charAt(i)-s.charAt(i));
        }
        return (char)answer;
    }
}

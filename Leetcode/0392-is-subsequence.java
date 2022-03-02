// https://leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        for(char c : t.toCharArray()){
            if(idx<s.length() && c==s.charAt(idx)){
                idx++;
            }
        }
        if(idx==s.length())
            return true;
        else
            return false;
    }
}

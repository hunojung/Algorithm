// https://leetcode.com/problems/reverse-words-in-a-string-iii/
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(String word : words){
            StringBuilder sb2 = new StringBuilder(word);
            if(sb.length()>0)sb.append(" ");
            sb.append(sb2.reverse());
        }
        return sb.toString();
    }
}

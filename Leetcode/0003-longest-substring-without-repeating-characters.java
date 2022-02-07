// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int start=0;
        HashMap<Character,Integer> chars = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char nextChar = s.charAt(i);
            while(chars.containsKey(nextChar)){
            	chars.remove(s.charAt(start));
                start++;
            }
            chars.put(nextChar,i);
            
            if(answer<i-start+1)answer=i-start+1;
        }
        return answer;
    }
}

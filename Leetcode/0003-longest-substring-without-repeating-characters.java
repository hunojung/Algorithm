// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// update
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int left = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);
            
            if(map.containsKey(now)){
                left = Math.max(left,map.get(now)+1);
            }
            
            map.put(now,i);
            answer = Math.max(answer,i-left+1);
        }
        
        return answer;
    }
}

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

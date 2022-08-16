// https://leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    public int firstUniqChar(String s) {
        
        int[] firstIndex = new int[26];
        int[] charCount = new int[26];
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            charCount[c-'a']++;
            if(charCount[c-'a']==1){
                firstIndex[c-'a'] = i;
            }
        }
        
        int answer = -1;
        for(int i=0;i<26;i++){
            if(charCount[i]==1){
                answer = answer==-1?firstIndex[i]:Math.min(answer,firstIndex[i]);
            }
        }
        
        return answer;
    }
}

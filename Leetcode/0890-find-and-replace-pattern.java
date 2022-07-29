// https://leetcode.com/problems/find-and-replace-pattern/
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        Map<Character,Integer> patternMap = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if(patternMap.containsKey(c)) continue;
        
            patternMap.put(c,i);
        }
        
        int[] patternArr = new int[pattern.length()];
        for(int i = 0; i<pattern.length();i++){
            char c = pattern.charAt(i);
            patternArr[i] = patternMap.get(c);
        }
        
        for(String s : words){
            
            if(compareString(patternArr,s)){
                answer.add(s);
            }
        }
        
        return answer;
    }
    
    boolean compareString(int[] patternArr, String s){
        Map<Character,Integer> sMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(sMap.containsKey(c))
                continue;
        
            sMap.put(c,i);
        }
        
        int[] arr = new int[s.length()];
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            arr[i] = sMap.get(c);
        }
        
        for(int i = 0; i<s.length();i++){
            if(patternArr[i] != arr[i]){
                return false;
            }
        }
        
        return true;
    }
}

// https://leetcode.com/problems/unique-morse-code-words/
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> transformed_string = new HashSet<>();
        
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()){
                sb.append(morses[c-'a']);
            }

            transformed_string.add(sb.toString());  
        }
        return transformed_string.size();
    }
}

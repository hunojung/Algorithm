// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
class Solution {
    public String removeDuplicateLetters(String s) {
        
        int[] lastIdx = new int[26];
        for(int i=0;i<s.length();i++) lastIdx[s.charAt(i)-'a']=i;
        
        boolean[] used = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            int check = s.charAt(i)-'a';
            if(used[check]) continue;
            
            while(!stack.isEmpty() && stack.peek()>check && i<lastIdx[stack.peek()]){
                used[stack.pop()]=false;
            }
            
            stack.push(check);
            used[check]=true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append((char) (stack.pop()+'a'));
        
        return sb.reverse().toString();
    }
}

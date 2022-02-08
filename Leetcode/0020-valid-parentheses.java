// https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char next = s.charAt(i);
            if(next=='(' || next=='{' || next=='['){
                stack.add(next);
            }else{
                if(stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if((next==')' && pop!='(') || (next=='}' && pop!='{')||(next==']' && pop!='[')){
                   return false;
                }
            }
        }
        if(stack.isEmpty())return true;
        return false;
    }
}

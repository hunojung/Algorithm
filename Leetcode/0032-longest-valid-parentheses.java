// https://leetcode.com/problems/longest-valid-parentheses/
class Solution {
    public int longestValidParentheses(String s) {        
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' && stack.size()>1 && s.charAt(stack.peek())=='('){
                stack.pop();
                answer = Math.max(answer,i-stack.peek());
            }else{
                stack.push(i);
            }
        }
        
        return answer;
    }
}


class Solution {
    public int longestValidParentheses(String s) {        
        int answer = 0;
        int left = 0, right = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') left++;
            else right++;
            
            if(left==right){
                answer = Math.max(answer,left+right);
            }else if(right>=left){
                left=right=0;
            }            
        }
        
        left=right=0;
        
        for(int i=s.length()-1;i>-1;i--){
            if(s.charAt(i)=='(') left++;
            else right++;
            
            if(left==right){
                answer = Math.max(answer,left+right);
            }else if(right<=left){
                left=right=0;
            }            
        }
        
        return answer;
    }
}

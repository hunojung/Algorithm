// https://leetcode.com/problems/validate-stack-sequences/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
  
        int pop_idx = 0;
        for(int n : pushed){
            stack.push(n);
            while(!stack.isEmpty() && stack.peek()==popped[pop_idx]){
                stack.pop();
                pop_idx++;
            }
        }
        
        return stack.size()==0;
    }
}

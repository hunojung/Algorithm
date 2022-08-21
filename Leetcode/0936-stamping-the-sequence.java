// https://leetcode.com/problems/stamping-the-sequence/
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        char[] T = target.toCharArray();
        char[] S = stamp.toCharArray();
        boolean[] used = new boolean[T.length-S.length+1];
        Stack<Integer> stack = new Stack<>();
        
        int stars = 0;
        
        while(stars<T.length){
            
            boolean changed = false;
            
            for(int i=0;i<T.length-S.length+1;i++){
                if(!used[i] && canChange(T,S,i)){
                    stars += change(T,S,i);
                    changed = true;
                    used[i] = true;
                    stack.push(i);
                }
            }
            
            if(!changed){
                stack.clear();
                break;
            }
        }
        
        int[] answer = new int[stack.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = stack.pop();
        }
        return answer;
    }
    
    public int change(char[] T,char[] S,int idx){
        int count = 0;
        for(int i=0;i<S.length;i++){
            if(T[i+idx] == '*') continue;
            
            T[i+idx] = '*';
            count++;
        }
        
        return count;
    }
    
    public boolean canChange(char[] T,char[] S,int idx){
        boolean can = true;
        
        for(int i=0;i<S.length;i++){
            if(T[i+idx] != '*' && T[i+idx] != S[i]){
                can = false;
                break;
            }
        }
        
        return can;
    }
}

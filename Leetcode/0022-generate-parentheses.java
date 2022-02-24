// https://leetcode.com/problems/generate-parentheses/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTracking(res,n,0,0,new StringBuilder());
        return res;
    }
    
    public void backTracking(List<String> res,int n, int open, int close,StringBuilder p){
        if(n==open && n==close){
            res.add(p.toString());
            return;
        }
        
        if(n>open){
            p.append("(");
            backTracking(res,n,open+1,close,p);
            p.delete(p.length()-1,p.length());
        }
        
        if(open>close){
            p.append(")");
            backTracking(res,n,open,close+1,p);
            p.delete(p.length()-1,p.length());
        }
    }
}

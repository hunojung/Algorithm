// https://leetcode.com/problems/letter-case-permutation/
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] c = s.toCharArray();
        dfs(res,c,0);
        return res;
    }
    public void dfs(List<String> res,char[] c,int idx){
        if(idx==c.length){
            res.add(new String(c));
            return;
        }
        
        if('a'<=c[idx] && c[idx]<='z'){
            c[idx]=(char)(c[idx]-32);
            dfs(res,c,idx+1);
            c[idx]=(char)(c[idx]+32);
        }else if('A'<=c[idx] && c[idx]<='Z'){
            c[idx]=(char)(c[idx]+32);
            dfs(res,c,idx+1);
            c[idx]=(char)(c[idx]-32);
        }
        dfs(res,c,idx+1);
    }
}

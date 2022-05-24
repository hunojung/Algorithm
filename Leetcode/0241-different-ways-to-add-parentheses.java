// https://leetcode.com/problems/different-ways-to-add-parentheses/
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        
        if(map.containsKey(expression)) return map.get(expression);
        
        int len = 0;
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1,expression.length()));
                
                for(int l:left){
                    for(int r:right){
                        if(c=='+') answer.add(l+r);
                        if(c=='-') answer.add(l-r);
                        if(c=='*') answer.add(l*r);
                    }
                }
            }else{
                len++;
            }
        }
        
        if(len==expression.length()) return Arrays.asList(Integer.parseInt(expression));
        
        map.put(expression,answer);
        
        return map.get(expression);
    }
}

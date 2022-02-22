// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class Solution {
    static String[] strings = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()<1)return res;
        
        Combination(res,digits,new StringBuilder(),0);
        return res;
    }
    
    static void Combination(List<String> res,String digits,StringBuilder s,int idx){
        if(idx==digits.length()){
            res.add(s.toString());
            return;
        }
        
        for(char c : strings[digits.charAt(idx)-'0'-2].toCharArray()){
            Combination(res,digits,s.append(c),idx+1);
            s.deleteCharAt(idx);
        }
    }
}

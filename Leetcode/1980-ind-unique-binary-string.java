// https://leetcode.com/problems/find-unique-binary-string/
class Solution {
    String answer = null;
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String n:nums){
            set.add(n);
        }
        StringBuilder sb = new StringBuilder();
        backTracking(set,sb,nums.length);
        return answer;
    }
    
    void backTracking(Set<String> set,StringBuilder sb,int n){
        if(answer != null) return;
        //System.out.println(sb.toString());
        
        if(sb.length()==n){
            if(!set.contains(sb.toString())){
                answer = sb.toString();
            }
            return;
        }
        
        sb.append('0');
        backTracking(set,sb,n);
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('1');
        backTracking(set,sb,n);
        sb.deleteCharAt(sb.length()-1);
    }
}

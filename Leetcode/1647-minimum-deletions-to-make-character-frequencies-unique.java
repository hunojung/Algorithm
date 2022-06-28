// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
class Solution {
    public int minDeletions(String s) {
        int answer = 0;
        int[] check = new int[26];
        Set<Integer> set = new HashSet<>();
        
        for(char c : s.toCharArray()){
            check[c-'a']++;
        }
        
        for(int i=0;i<26;i++){
            
            while(check[i]>0 && set.contains(check[i])){
                check[i]--;
                answer++;
            }
            set.add(check[i]);
        }
        
        return answer;
    }
}

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        
        int[] pCount = new int[26];
        int[] count = new int[26];
        
        for(char c : p.toCharArray())pCount[c-'a']++;
        
        int l=0,r = 0;
        while(r<s.length()){
        	count[s.charAt(r)-'a']++;
        	
        	if(r-l==p.length()){
        		count[s.charAt(l)-'a']--;
        		l++;
        	}
        	
        	if(Arrays.equals(count, pCount))answer.add(l);
        	r++;
        }
        return answer;
    }
}

// https://leetcode.com/problems/palindrome-pairs/

// Based on the 3 examples given by LeetCode, we can derive 3 conditions where str1 + str2 = palindrome.
// Case 1: If there is str1 "", and str2 that is palindrome, then str1 + str2 ("" + palindrome) is still a palindrome.
//         From Example 3: words = ["a",""]
//                         str1 = "", str2 = "a" (a palindrome), so str1 + str2 = "a" (a palindrome).
//
// Case 2: If str1 is the reverse of str2, then str1 + str2 and str2 + str1 are both palindromes.
//         From Example 2: words = ["bat"*,"tab"*,"cat"]
//                         str1 = "bat, str2 = "tab", str1 is the reverse of str2,
//                         so str1 + str2 = "battab", and str2 + str1 = "tabbat".
//
// Case 3: If str1 is the reverse of a part of str2 (sub1 + sub2), and the second part is a palindrome, then the following:
//         A. If str1 is the reverse of sub1, and sub2 is palindrome, then str2 + str1 = palindrome.
//         B. If str1 is the reverse of sub2, and sub1 is palindrome, then str1 + str2 = palindrome.
//         From Example 1: words = ["abcd","dcba","lls"*,"s"*,"sssll"*]
//                         A. Not shown here.
//                         B. str1 = "s", str2 = "lls" (sub1 = "ll", sub2 = "s"), or
//                            str1 = "lls", str2 = "sssll" (sub1 = "ss", sub2 = "sll")
//                         Both cases, str1 is the reverse of sub2, and sub1 is a palindrome.
//

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> answer = new ArrayList<>();
    	Map<String,Integer> wordMap = new HashMap<>();
        Set<Integer> lengthSet = new TreeSet<>();
        
        for(int i=0;i<words.length;i++){
            wordMap.put(words[i],i);
            lengthSet.add(words[i].length());
        }
        
        for(int i=0;i<words.length;i++){
            int length = words[i].length();
            String reverse = reverseString(words[i]);
            
            if(wordMap.containsKey(reverse) && wordMap.get(reverse)!=i){
                answer.add(Arrays.asList(i,wordMap.get(reverse)));
            }
            
            for(Integer k : lengthSet){
                if(k == length) break;
                
                if(isPalindrome(reverse,0,length-1-k)){
                    String s1 = reverse.substring(length-k);
                    if(wordMap.containsKey(s1))
                        answer.add(Arrays.asList(i,wordMap.get(s1)));
                }
                
                if(isPalindrome(reverse,k,length-1)){
                    String s2 = reverse.substring(0,k);
                    if(wordMap.containsKey(s2))
                        answer.add(Arrays.asList(wordMap.get(s2),i));
                }
                
            }
        }
        
        return answer;
    }
    
    public String reverseString(String word){
        return new StringBuilder(word).reverse().toString();
    }
    
    public boolean isPalindrome(String word,int l,int r) {
    	while(l<r)
            if(word.charAt(l++)!=word.charAt(r--))
                return false;
    	return true;
    }
}

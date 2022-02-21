// https://leetcode.com/problems/longest-palindromic-substring/
// second submit
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1,maxStart=0;
        char[] c = s.toCharArray();
        String res = s.charAt(0)+"";
        int i=0;
        while(i<len){

            int l=i-1,r=i;
            while(r<len && c[i]==c[r])
                r++;
            i=r;
            while(l>=0 && r<len && c[l]==c[r]){
                r++;
                l--;
            }
            
            int newLen = r-l-1;
            if(maxLen<newLen){
                maxStart=l+1;
                maxLen = newLen;
            }
        }
        return s.substring(maxStart,maxStart+maxLen);
    }
}

// first submit
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = s.charAt(0)+"";
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(res.length()<j+1-i){
                    boolean palindrome = true;

                    for(int k=0;(i+k)<(j-k);k++){
                        if(s.charAt(i+k)!=s.charAt(j-k)){
                            palindrome=false;
                            break;
                        }
                    }
                    if(palindrome){
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        
        return res;
    }
}

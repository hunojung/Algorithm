// https://leetcode.com/problems/maximum-product-of-word-lengths/
class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] mask = new int[words.length];
        for(int i=0;i<words.length;i++){
            for(char c : words[i].toCharArray()){
                mask[i] |= mask[i]|(1<<c-'a');
            }
        }
        
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i]&mask[j])==0)
                    max = Math.max(max, words[i].length()*words[j].length());
            }
        }            
        
        return max;
    }
}

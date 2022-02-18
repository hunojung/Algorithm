// https://leetcode.com/problems/remove-k-digits/
class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length())return "0";
        
        int len = num.length();
        char[] stack = new char[len];
        int end = 0,start = 0;
        
        for(int i=0;i<len;i++){
            while(end>0 && k>0 && stack[end-1]>num.charAt(i)){
                k--;
                end--;
            }
            
            stack[end] = num.charAt(i);
            end++;
        }
        
        end-=k;
        // 남은게 다 0뿐이면 start<end-1 을 통해 1개 남겨놓고 답에 0 나오게함
        while(stack[start]=='0' && start<end-1)
            start++;
        return String.valueOf(stack,start,end-start);
    }
}

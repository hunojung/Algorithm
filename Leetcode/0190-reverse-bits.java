// https://leetcode.com/problems/reverse-bits/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        for(int i=0;i<31;i++){
            answer += n&1;
            answer <<= 1;
            n >>= 1;
        }
        answer += n&1;
        return answer;
    }
}

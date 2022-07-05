// https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long answer = 0;
        for(int i=0;i*cost1<=total;i++){
            int sub = total-i*cost1;
            answer += sub/cost2+1;
        }
        return answer;
    }
}

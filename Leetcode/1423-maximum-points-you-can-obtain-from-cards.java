// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        
        for(int i=0;i<k;i++){
            total += cardPoints[i];
        }
        
        int l = k-1 , r = n-1;
        int answer = total;
        while(l>=0){
            total += (cardPoints[r]-cardPoints[l]);
            answer = Math.max(answer, total);
            l--;
            r--;
        }
        
        return answer;
    }
}

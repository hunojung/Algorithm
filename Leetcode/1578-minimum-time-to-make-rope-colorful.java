// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char[] arr = colors.toCharArray();
        int answer = 0;
        int before = 0;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[before]){
                before = i;
            }else{
                if(neededTime[i]<neededTime[before]){
                    answer += neededTime[i];
                }else{
                    answer += neededTime[before];
                    before = i;
                }
            }
        }
        return answer;
    }
}

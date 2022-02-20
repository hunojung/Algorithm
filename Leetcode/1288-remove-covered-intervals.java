// https://leetcode.com/problems/remove-covered-intervals/
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int l = 0,r=intervals.length;
        for(int i=0;i<r-1;i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            for(int j=i+1;j<r;j++){
                int c = intervals[j][0];
                int d = intervals[j][1];
                if(a>=c && b<=d){
                    l++;
                    break;
                }
                
                if(a<=c && b>=d){
                    intervals[j][0]=intervals[r-1][0];
                    intervals[j][1]=intervals[r-1][1];
                    j--;
                    r--;
                }
            }
        }
        return r-l;
    }
}

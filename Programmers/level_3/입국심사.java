import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = 0 , r  = times[times.length-1] * (long)n;
        while(l<=r){
            long mid = (r-l)/2+l;
            
            if(countPeople(times,mid)<n){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
    
    private long countPeople(int[] times, long mid){
        long count = 0;
        for(int i=0;i<times.length;i++){
            if(mid/times[i]>0)
                count += mid/times[i];
            else
                break;
        }
        return count;
    }
}

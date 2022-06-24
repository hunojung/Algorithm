// https://leetcode.com/problems/construct-target-array-with-multiple-sums/
class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1 ) return target[0]==1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int sum = 0;
        
        for(int t : target){
            pq.add(t);
            sum += t;
        }
        
        while(pq.peek()>1){
            int t = pq.poll();
            sum -= t;
            int next_t = t - ((t-1)/sum)*sum;
            
            if(next_t == 0 || t==next_t) return false;
            
            sum += next_t;
            pq.add(next_t);
            
        }
        
        return true;
    }
}

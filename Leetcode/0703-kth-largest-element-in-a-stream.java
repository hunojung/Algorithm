// https://leetcode.com/problems/kth-largest-element-in-a-stream/
class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num : nums) add(num);
    }
    
    public int add(int val) {
        
        if(pq.size()==k){
            if(pq.peek()<val){
                pq.poll();
                pq.add(val);
            }
        }else{
            pq.add(val);
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// https://leetcode.com/problems/split-array-into-consecutive-subsequences/
class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        int max_idx = nums[n-1]-nums[0]+1;
        int[] count = new int[max_idx];
        
        for(int num : nums) count[num-nums[0]]++;
        
        for(int i=0;i<max_idx;i++){
                
            if(count[i]==0) continue;
            
            int now = i;
            while(now<max_idx-1 && count[now] <= count[now+1] ){
                //System.out.println(now);
                count[now++] --;
            }
            count[now]--;
            
            if( now-i < 2 ) return false;
            if(count[i]!=0) i--;
        }
        
        return true;
    }
}

// first submit
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : map.keySet()){
            pq.add(num);
        }
        
        while(!pq.isEmpty()){
            int min = pq.peek();
            int count = 0;
            while(true){
                
                if(!map.containsKey(min)){
                    if(count<3) return false;
                    break;
                }
                
                map.put(min,map.get(min)-1);
                count++;
                
                if(map.get(min)==0){
                    if(min != pq.peek()) return false;
                    
                    pq.poll();
                }
                
                if(map.containsKey(min+1) && map.get(min)+1 > map.get(min+1)){
                    if(count<3) return false;
                    break;
                }
                
                min += 1;
            }
        }
        return true;
    }
}

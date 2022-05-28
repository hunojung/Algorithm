// https://leetcode.com/problems/random-pick-with-blacklist/
class Solution {
    private Map<Integer,Integer> map;
    private int size;
    private Random random = new Random();
    
    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        size = n-blacklist.length;
        for(int b : blacklist){
            map.put(b,0);
        }
        
        int top = size;
        for(int b:blacklist){
            if(b<size){
                while(map.containsKey(top)) top++;
            
                map.put(b,top++);
            }
        }
    }
    
    public int pick() {
        int n = random.nextInt(size);
        return map.getOrDefault(n,n);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */

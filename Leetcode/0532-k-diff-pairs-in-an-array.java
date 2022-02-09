// https://leetcode.com/problems/k-diff-pairs-in-an-array/
// 두가지 방법으로 해결

// two point
class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        int low = 0, high = 1;
        
        Arrays.sort(nums);
        
        while(high < nums.length && low < nums.length){
            int diff = nums[high]-nums[low];
            if(high == low || diff<k){
                high++;
            }else if( diff > k ){
                low++;
            }else{
                res++;
                low++;
                while(low<nums.length && nums[low]==nums[low-1]){
                    low++;
                }
            }
        }   
        
        return res;
    }
}

// HashMap
class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(int i : map.keySet()){
            if(map.containsKey(k+i)){
                if(i==(k+i)){
                    if(map.get(i)>1)
                        answer++;
                }else{
                    answer++;
                }
            }
            
            if(map.containsKey(i-k)){
                if(i==(i-k)){
                    if(map.get(i)>1)
                        answer++;
                }else{
                    answer++;
                }
            }
        }
        return answer/2;
    }
}

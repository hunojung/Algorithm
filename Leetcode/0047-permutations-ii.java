// https://leetcode.com/problems/permutations-ii/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        
        backTracking(res,new ArrayList<>(),nums,visited);
        return res;
    }
    
    void backTracking(List<List<Integer>> res , List<Integer> list, int[] nums, boolean[] visited){
        
        if(list.size()==nums.length){
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            visited[i]=true;
            list.add(nums[i]);
            
            backTracking(res,list,nums,visited);
            
            visited[i]=false;
            list.remove(list.size()-1);
            
        }
    }
}

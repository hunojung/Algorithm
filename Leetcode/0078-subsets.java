// https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,nums,0,new ArrayList<>());
        return res;
    }
    
    static void backtracking(List<List<Integer>> res,int[] nums,int start, List<Integer> addList){
        res.add(new ArrayList(addList));
        if(start == nums.length)
            return;
        
        for(int i=start; i<nums.length; i++){
            addList.add(nums[i]);
            backtracking(res,nums,i+1,new ArrayList(addList));
            addList.remove(addList.size()-1);
        }
    }
}

// https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combination(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }
    
    static void combination(List<List<Integer>> res,List<Integer> arr,int[] candidates,int target,int start,int sum){
    	
    	if(target==sum){
    		res.add(new ArrayList(arr));
    		return;
    	}
    	
    	for(int i=start;i<candidates.length;i++){
    		if(sum+candidates[i]<=target){
    			arr.add(candidates[i]);
    			combination(res,arr,candidates,target,i,sum+candidates[i]);
    			arr.remove(arr.size()-1);
    		}
    	}
    }
}

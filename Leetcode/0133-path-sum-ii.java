// https://leetcode.com/problems/path-sum-ii/
class Solution {
    private List<List<Integer>> answer;
    private int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answer = new ArrayList<>();
        this.targetSum = targetSum;
        
        if(root != null) checkPath(root,0,new ArrayList<>());
            
        return answer;
    }
    
    private void checkPath(TreeNode root,int sum,List<Integer> list){
        
        list.add(root.val);
        
        if(sum+root.val == targetSum){
            if(root.left == null && root.right == null){
                answer.add(new ArrayList<>(list));
            }
        }
        
        if(root.left != null) checkPath(root.left, sum+root.val, list);
        if(root.right != null) checkPath(root.right, sum+root.val, list);
        
        list.remove(list.size()-1);
    }
}

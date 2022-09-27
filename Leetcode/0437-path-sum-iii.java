// https://leetcode.com/problems/path-sum-iii/
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
      
        return dfs(root,0,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    public int dfs(TreeNode root,long sum,int targetSum){
        if(root == null){
            return 0;
        }
        
        return (sum+root.val==targetSum?1:0)+dfs(root.left,sum+root.val,targetSum)+dfs(root.right,sum+root.val,targetSum);
    }
}


    

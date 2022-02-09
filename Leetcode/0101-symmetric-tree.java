// https://leetcode.com/problems/symmetric-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        boolean res = true;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root.left != null && root.right != null){
            q.add(root.left);
            q.add(root.right);
        }else if(root.left==null && root.right == null){
            res = true;
        }else {
            res = false;
        }
        
        while(!q.isEmpty()){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            
            if(left.val == right.val){
                
                if(left.left!=null && right.right!=null){
                    q.add(left.left);
                    q.add(right.right);
                }
                
                if(left.right!=null && right.left!=null){
                    q.add(left.right);
                    q.add(right.left);
                }
                
                if((left.left != null && right.right==null) || (left.left == null && right.right!=null)){
                    res = false;
                    break;
                }

                if((left.right == null && right.left!=null) || (left.right != null && right.left==null)){
                    res = false;
                    break;
                }
            
            // left.val != right.val
            }else{
                res = false;
                break;
            }
        }
        
        return res;
    }
}

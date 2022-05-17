// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode node = null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if(original!=null){
            
            if(original==target){
                
                node = cloned;
                
            }else{
                
                TreeNode left = getTargetCopy(original.left,cloned.left,target);
                
                if(left == null){
                    return getTargetCopy(original.right,cloned.right,target);
                }
                
                return left;
            }
        }
        
        return node;
    }
}

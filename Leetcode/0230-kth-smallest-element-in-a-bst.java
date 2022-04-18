// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    int res = -1;
    int globalK = 0;
    public int kthSmallest(TreeNode root, int k) {
        globalK=k;
        
        inOrder(root);
        
        return res;
    }
    
    public void inOrder(TreeNode root){
        if(root==null) return;
        
        inOrder(root.left);
        
        if(globalK==1) res = root.val;
        
        globalK--;
        
        inOrder(root.right);
    }
}

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            for(int i=0;i<size;i++){
                
                TreeNode now = q.poll();
                
                if(now.left==null && now.right==null){
                    q.clear();
                    break;
                }
                
                if(now.left!=null) q.add(now.left);
                if(now.right!=null) q.add(now.right);
            }
        }
        return depth;
    }
}

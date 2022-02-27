// https://leetcode.com/problems/maximum-width-of-binary-tree/
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
    public int widthOfBinaryTree(TreeNode root) {
        int answer = 1;
        Queue<TreeNode> q = new LinkedList<>();
        root.val=0;
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            int min = q.peek().val;
            int max = min;
            
            for(int i=0;i<size;i++){
                TreeNode next = q.poll();
                
                if(next.left!=null){
                    next.left.val=next.val*2;
                    q.add(next.left);
                }
                
                if(next.right!=null){
                    next.right.val=next.val*2+1;
                    q.add(next.right);
                }
                if(i==size-1)
                    max = next.val;
            }
            answer = Math.max(answer,max-min+1);
        }
        
        return answer;
    }
}

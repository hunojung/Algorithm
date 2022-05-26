// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        bfs(answer,root,0);
        return answer;
    }
    
    private void bfs(List<List<Integer>> answer,TreeNode root,int idx){
        
        if(root==null) return;
        
        if(answer.size()<idx+1) answer.add(new ArrayList<>());
        
        if(idx%2==0) answer.get(idx).add(root.val);
        else answer.get(idx).add(0,root.val);
        
        bfs(answer,root.left,idx+1);
        bfs(answer,root.right,idx+1);
    }
}

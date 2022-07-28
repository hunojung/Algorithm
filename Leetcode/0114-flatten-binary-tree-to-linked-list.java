// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode dummy = root;
        
        Stack<TreeNode> stack = new Stack<>();
        if(dummy.right != null) stack.push(dummy.right);
        if(dummy.left != null) stack.push(dummy.left);
        dummy.left = null;
        
        while(!stack.isEmpty()){
            TreeNode now = stack.pop();
            
            if(now.right != null) stack.push(now.right);
            if(now.left != null) stack.push(now.left);
            
            dummy.left = null;
            dummy.right = now;
            dummy = dummy.right;
        }
    }
}

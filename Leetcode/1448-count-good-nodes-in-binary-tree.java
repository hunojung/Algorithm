// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
class Solution {
    int answer;
    public int goodNodes(TreeNode root) {
        this.answer = 1;
        check_node(root.right,root.val);
        check_node(root.left,root.val);
        
        return answer;
    }
    public void check_node(TreeNode root ,int val){
        if(root==null) return;
        if(root.val >= val) answer++;
            check_node(root.right, Math.max(val,root.val));
        check_node(root.left,Math.max(val,root.val));
    }
}

// https://leetcode.com/problems/diameter-of-binary-tree/

//second submit
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        treeDepth(root);
        return max;
    }
    
    public int treeDepth(TreeNode root){
        if(root == null)return 0;
        
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        max = Math.max(left+right,max);
        return 1 + Math.max(left,right);
    }
}


// first submit
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] left = treeDepth(root.left);
        int[] right = treeDepth(root.right);
        return Math.max(left[0]+right[0],Math.max(left[1],right[1]));
    }
    
    public int[] treeDepth(TreeNode root){
        if(root == null)return new int[] {0,0};
        
        int[] left = treeDepth(root.left);
        int[] right = treeDepth(root.right);
        int maxDepth = Math.max(left[0],right[0])+1;
        int maxDiameter = Math.max(left[0]+right[0],Math.max(left[1],right[1]));
        return new int[] {maxDepth,Math.max(maxDepth,maxDiameter)};
    }
}

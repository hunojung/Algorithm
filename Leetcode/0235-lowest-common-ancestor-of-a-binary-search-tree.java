// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        
        return root;
    }
}

// first submin
class Solution {
    TreeNode answer;
    int bigNum, smallNum;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        answer = null;
        bigNum = Math.max(p.val, q.val);
        smallNum = Math.min(p.val, q.val);
        
        dfs(root,root.val,root.val);
        
        return answer;
    }
    
    void dfs(TreeNode root, int max, int min){
        
        if(max < smallNum){

            dfs(root.right, root.right.val, root.right.val);
            
        }else if(min > bigNum){

            dfs(root.left, root.left.val, root.left.val);
            
        }else{
            if(answer == null || answer.val > root.val){
                answer = new TreeNode(root.val);
            }
            
//             if(root.left != null && root.left.val >= smallNum && root.val > bigNum){
//                 dfs(root.left, root.val,min);
//             }
            
//             if(root.right != null && root.right.val <= bigNum && root.val < smallNum){
//                 dfs(root.right, max,root.val);
//             }
        }
    }
}

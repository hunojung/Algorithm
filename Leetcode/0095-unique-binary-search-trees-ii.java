// https://leetcode.com/problems/unique-binary-search-trees-ii/
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
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    
    private List<TreeNode> helper(int s,int e){
        List<TreeNode> answer = new ArrayList<>();
        if(s>e){
            answer.add(null);
            return answer;
        }
        
        for(int mid = s ; mid<=e ; mid++){
            List<TreeNode> leftTree = helper(s,mid-1);
            List<TreeNode> rightTree = helper(mid+1,e);
            for(TreeNode left : leftTree){
                for(TreeNode right : rightTree){
                    answer.add(new TreeNode(mid,left,right));
                }
            }
        }
        return answer;
    }
}

////////////// 첫 제출
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> answer = new ArrayList<>();
        boolean[] used = new boolean[n+1];
        for(int i=1;i<=n;i++){
            used[i]=true;
            TreeNode head = new TreeNode(i);
            dfs(answer,used,n,1,head);
            used[i]=false;
        }
        
        return answer;
    }
    
    private void copyTree(TreeNode head, TreeNode now){
        if(head.left!=null){
            now.left = new TreeNode(head.left.val);
            copyTree(head.left,now.left);
        }
        if(head.right!=null){
            now.right = new TreeNode(head.right.val);
            copyTree(head.right,now.right);
        }
    }
    
    private void insertTree(TreeNode head,int i){
        if(head.val<i){
            if(head.right==null) head.right = new TreeNode(i);
            else insertTree(head.right,i);
        }else if(head.val>i){
            if(head.left==null) head.left = new TreeNode(i);
            else insertTree(head.left,i);
        }
    }
    
    private void deleteTree(TreeNode head,int i){
        if(head.val<i){
            if(head.right.val==i) head.right=null;
            else deleteTree(head.right,i);
        }else{
            if(head.left.val==i) head.left=null;
            else deleteTree(head.left,i);
        }
    }
    
    private boolean checkTree(List<TreeNode> answer,TreeNode head){
        for(TreeNode ans : answer){
            //System.out.println(answer.size()+" "+ans.val+" "+head.val);
            if(sameTree(ans,head)) return false;
        }
        
        return true;
    }
    
    private boolean sameTree(TreeNode ans, TreeNode head){
        if(ans == null && head == null) return true;
        else if(ans !=null && head !=null && ans.val==head.val){
            //System.out.println(ans.val +" "+ head.val);
            if(sameTree(ans.left,head.left) && sameTree(ans.right,head.right)){
                return true;
            }
        }
        return false;
    }
    
    private void dfs(List<TreeNode> answer,boolean[] used,int n,int count, TreeNode head){
        if(count==n && checkTree(answer,head)){
            TreeNode newTree = new TreeNode(head.val);
            copyTree(head,newTree);
            answer.add(newTree);
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(used[i]) continue;
            
            used[i]=true;
            insertTree(head,i);
            
            dfs(answer,used,n,count+1,head);
            
            used[i]=false;
            deleteTree(head,i);
        }
    }
}

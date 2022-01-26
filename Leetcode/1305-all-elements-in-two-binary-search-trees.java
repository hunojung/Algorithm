// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

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
import java.util.*;
class Solution {
    static List<Integer> list;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        if(root1!=null)insert(root1);
        if(root2!=null)insert(root2);
        Collections.sort(list);
        return list;
    }
    static void insert(TreeNode root){
    	
      list.add(root.val);
    	if(root.left!=null)insert(root.left);
    	if(root.right!=null)insert(root.right);
    }
}

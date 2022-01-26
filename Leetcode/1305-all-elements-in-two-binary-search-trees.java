// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

// updated code
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    	LinkedList<Integer> list = new LinkedList<>();
    	List<Integer> list2 = new ArrayList<>();

        dfs(root1,list);
        dfs2(root2,list,list2);
        // 다 추가하고 남은거 더 추가
        if(list.size()>0)list2.addAll(list);
        return list2;
    }
    
    static void dfs2(TreeNode root,LinkedList<Integer> list, List<Integer> list2){
    	if(root==null)return;
    	
    	if(root.left!=null)dfs2(root.left,list,list2);
    	
    	while(!list.isEmpty() && root.val>=list.peekFirst()){
    		list2.add(list.pollFirst());
    	}
    	
    	list2.add(root.val);
    	if(root.right!=null)dfs2(root.right,list,list2);
    }
    
    static void dfs(TreeNode root, List<Integer> list){
    	
    	if(root==null)return;
    	if(root.left!=null)dfs(root.left,list);
    	list.add(root.val);
    	if(root.right!=null)dfs(root.right,list);
    }
}

// first submit code
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

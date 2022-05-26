// https://leetcode.com/problems/n-ary-tree-level-order-traversal/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        bfs(answer,root,0);
        return answer;
    }

    private void bfs(List<List<Integer>> answer,Node root,int idx){

        if(root==null) return;

        if(answer.size()<idx+1) answer.add(new ArrayList<>());

        answer.get(idx).add(root.val);

        for(Node n : root.children)
            bfs(answer,n,idx+1);
    }

}

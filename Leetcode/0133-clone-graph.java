// https://leetcode.com/problems/clone-graph/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        Map<Integer,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        Node head = new Node(node.val);
        Node res = head;
        map.put(head.val,head);

        q.add(node);
        q.add(head);
        
        while(!q.isEmpty()){
            Node nodeNow = q.poll();
            Node headNow = q.poll();
    
            for(int i=0;i<nodeNow.neighbors.size();i++){
                Node nodeNext = nodeNow.neighbors.get(i);
                if(map.containsKey(nodeNext.val)){
                    headNow.neighbors.add(map.get(nodeNext.val));
                    
                }else{
                    Node headNext = new Node(nodeNext.val);
                    headNow.neighbors.add(headNext);
                    map.put(headNext.val,headNext);
                    
                    q.add(nodeNext);
                    q.add(headNext);
                }
            }
        }
        return res;
    }
}

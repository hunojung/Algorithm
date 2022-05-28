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
    Map<Integer,Node> map = new HashMap<>();
        
    public Node cloneGraph(Node node) {
        
        // head
        if(node == null) return null;
        Node head = new Node(node.val);
        map.put(head.val,head);
        
        // neighbors 
        if(node.neighbors.size()>0){
            head.neighbors = new ArrayList<>();
            
            for(Node n : node.neighbors){
                // aleady exist val
                if(map.containsKey(n.val)){
                    head.neighbors.add(map.get(n.val));
                    
                // new val
                }else{
                    head.neighbors.add(cloneGraph(n));
                    
                }
            }
        }
        
        return head;
    }
}

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

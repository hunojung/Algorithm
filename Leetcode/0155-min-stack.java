// https://leetcode.com/problems/min-stack/
class MinStack {

    Node root;
    
    public MinStack() {
    }
    
    public void push(int val) {
        if(root==null)
            root = new Node(val,val,null);
        else
            root = new Node(val,Math.min(root.min,val),root);        
    }
    
    public void pop() {
        root = root.next;
    }
    
    public int top() {
        return root.val;
    }
    
    public int getMin() {
        return root.min;
    }
    
    private class Node{
        int val;
        int min;
        Node next;
        public Node(int val,int min,Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

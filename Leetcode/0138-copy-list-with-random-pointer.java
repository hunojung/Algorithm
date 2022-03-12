// https://leetcode.com/problems/copy-list-with-random-pointer/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return head;
        Node head_dummy = head;
        
        Node ans = new Node(head_dummy.val);
        head_dummy = head_dummy.next;
        Node ans_dummy = ans;
        
        while(head_dummy!=null){
            ans_dummy.next = new Node(head_dummy.val);
            ans_dummy = ans_dummy.next;
            head_dummy = head_dummy.next;
        }
        
        ans_dummy = ans;
        head_dummy = head;
        while(head_dummy!=null){
            
            if(head_dummy.random!=null){
                Node ans_dummy2 = ans;
                Node head_dummy2 = head;
                
                while(head_dummy2!=head_dummy.random){
                    ans_dummy2 = ans_dummy2.next;
                    head_dummy2 = head_dummy2.next;
                }
                
                ans_dummy.random = ans_dummy2;
                
            }
            
            ans_dummy = ans_dummy.next;
            head_dummy = head_dummy.next;
        }
        
        return ans;
    }
}

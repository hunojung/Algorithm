// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode left=null,right=null,node = head;
        
        while(node!=null){
            right = right==null?null:right.next;
            k--;
            if(k==0){
                right=head;
                left=node;
            }
            node=node.next;
        }
        
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        
        return head;
    }
}

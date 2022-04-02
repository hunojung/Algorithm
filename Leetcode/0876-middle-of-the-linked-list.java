// https://leetcode.com/problems/middle-of-the-linked-list/
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
    public ListNode middleNode(ListNode head) {
        ListNode dummy1 = head;
        ListNode dummy2 = head;
        while(dummy2!=null && dummy2.next!=null){
            dummy1 = dummy1.next;
            dummy2 = dummy2.next.next;
        }
        
        return dummy1;
    }
}

// first submit
class Solution {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode dummy = head;
        while(dummy!=null){
            dummy = dummy.next;
            len++;
        }
        
        dummy = head;
        len /= 2;
        while(len-->0){
            dummy = dummy.next;
        }
        
        return dummy;
    }
}

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null &&  fast.next != null){
            fast = fast.next.next;
            
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;
    }
}

// first submit
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        
        int len = check_middle_len(head);
        ListNode dummy = head;
        while(len-->1){
            dummy = dummy.next;
        }
        
        ListNode next_dummy = dummy.next.next;
        dummy.next = next_dummy;
        
        return head;
    }
    
    public int check_middle_len(ListNode head){
        int len = 0;
        ListNode dummy = head;
        while(dummy != null){
            dummy = dummy.next;
            len++;
        }
        return len/2;
    }
}

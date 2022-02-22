// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = head;
        int cnt = 0;
        while(dummy!=null && ++cnt>0)
            dummy=dummy.next;

        if(n==cnt)
            return head.next;
        
        dummy = head;
        while(--cnt>n)
            dummy = dummy.next;
        
        dummy.next = dummy.next.next;
        return head;
    }
}

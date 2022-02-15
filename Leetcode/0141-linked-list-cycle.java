// https://leetcode.com/problems/linked-list-cycle/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode next = head;
        Set<ListNode> set = new HashSet<>();
        while(next!=null){
            if(set.contains(next)){
                return true;
            } else {
                set.add(next);
            }
            
            next = next.next;
            
        }
        return false;
    }
}

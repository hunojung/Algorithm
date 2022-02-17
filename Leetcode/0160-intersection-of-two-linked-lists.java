// https://leetcode.com/problems/intersection-of-two-linked-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0,b = 0;
        ListNode dummy = headA;
        while(dummy!=null){
            dummy = dummy.next;
            a++;
        }
        
        dummy = headB;
        while(dummy!=null){
            dummy = dummy.next;
            b++;
        }
        
        while(a>b){
            headA=headA.next;
            a--;
        }
        
        while(a<b){
            headB=headB.next;
            b--;
        }
        
        while(headA!=null && headB!=null){
            if(headA==headB)return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}

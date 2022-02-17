// https://leetcode.com/problems/reverse-linked-list/

// second submit
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
    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null)
            return head;
        
        ListNode res = reverseList(head.next);
        ListNode resNext = head.next;
        resNext.next = head;
        head.next=null;
        
        return res;
    }
}

// first submit
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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        
        if(stack.size()==0)return null;
        
        ListNode res = new ListNode(stack.pop());
        ListNode dummy = res;
        while(!stack.isEmpty()){
            dummy.next = new ListNode(stack.pop());
            dummy = dummy.next; 
        }
        
        return res;
    }
}

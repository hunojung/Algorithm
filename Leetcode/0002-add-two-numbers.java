// https://leetcode.com/problems/add-two-numbers/description/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ten = 0;
        int nextNum=0;
        ListNode answer=null;
        ListNode nextNode=null;
        
        while(l1 !=null || l2 !=null || ten!=0){
            nextNum=ten;
            if(l2!=null){
                
                nextNum += l2.val;
                l2=l2.next;
            }
            
            if(l1!=null){
                nextNum += l1.val;
                l1=l1.next;
            }
            
            ten=nextNum/10;
            nextNum=nextNum%10;
            
            if(answer==null){
                
                answer= new ListNode(nextNum);
                
            }else if(nextNode == null){
                
                answer.next = new ListNode(nextNum);
                
                nextNode = answer.next;
                
                }else{
                
                nextNode.next = new ListNode(nextNum);
                
                nextNode = nextNode.next;
                
            }
        }
        return answer;
    }
}

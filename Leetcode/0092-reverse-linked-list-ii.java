// https://leetcode.com/problems/reverse-linked-list-ii/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode left_dummy = head;
        int l = 1;
        while(l<left){
            left_dummy = left_dummy.next;
            l++;
        }
        
        while(left<right){
            
            ListNode right_dummy = head;
            int r = 1;
            while(r<right){
                right_dummy = right_dummy.next;
                r++;
            }
            
            int tmp = left_dummy.val;
            left_dummy.val = right_dummy.val;
            right_dummy.val = tmp;
            
            left++;
            right--;
            
            left_dummy = left_dummy.next;
            
        }
        
        return head;
    }
}

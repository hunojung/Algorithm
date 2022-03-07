// https://leetcode.com/problems/merge-two-sorted-lists/

// second
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)
            return list2;
        
        if(list2==null)
            return list1;
        
        if(list2.val>list1.val){
            ListNode ans = new ListNode(list1.val);
            ans.next = mergeTwoLists(list1.next,list2);
            return ans;
        }else{
            ListNode ans = new ListNode(list2.val);
            ans.next = mergeTwoLists(list1,list2.next);
            return ans;
        }
    }
}

// first
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null)return list2;
        if(list2==null)return list1;
        
        ListNode root;
        
        if(list1.val>list2.val){
            root = new ListNode(list2.val);
            list2 = list2.next;
        }else{
            root = new ListNode(list1.val);
            list1 = list1.next;
        }
        
        ListNode next = root;
        
        while(list1!=null && list2!=null){

            if(list1.val>list2.val){
                next.next = new ListNode(list2.val);
                next=next.next;
                
                list2=list2.next;
                
            }else{
                next.next = new ListNode(list1.val);
                next=next.next;
                
                list1=list1.next;
            }
        }
        
        if(list1!=null){
            next.next = list1;
        }else if(list2!=null){
            next.next = list2;
        }
        
        return root;
    }
}

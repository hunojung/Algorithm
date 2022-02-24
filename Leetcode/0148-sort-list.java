// https://leetcode.com/problems/sort-list/
class Solution {
    public ListNode sortList(ListNode head) {

        //return pqSortList(head);
        return intSortList(head);
    }
    
    ListNode intSortList(ListNode head){
        ListNode dummy = head;
        int cnt = 0;
        
        while(dummy!=null){
            dummy = dummy.next;
            cnt++;
        }
        
        dummy = head;
        int[] vals = new int[cnt];
        for(int i=0;i<cnt;i++){
            vals[i]=dummy.val;
            dummy=dummy.next;
        }
        
        Arrays.sort(vals);
        dummy = head;
        
        for(int i=0;i<cnt;i++){
            dummy.val = vals[i];
            dummy = dummy.next;
        }
        
        return head;
    }
    
    public ListNode pqSortList(ListNode head) {
        if(head==null)return null;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(head!=null){
            pq.add(head.val);
            head = head.next;
        }
        
        ListNode res = new ListNode(pq.poll());
        ListNode dummy = res;
        while(!pq.isEmpty()){
            dummy.next = new ListNode(pq.poll());
            dummy = dummy.next;
        }
        
        return res;
    }
}

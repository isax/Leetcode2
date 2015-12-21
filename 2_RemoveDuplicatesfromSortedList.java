/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode p = prev.next;
        
        while(p!=null){
            ListNode q = p.next;
            
            while(q!=null && q.val==p.val){
                q = q.next;
            }
            
            if(p.next!=q){ // there are duplicates
                prev.next = q;
            }else{
                prev = prev.next;
            }
            p = q;
        }
        return dummy.next;
    }
}

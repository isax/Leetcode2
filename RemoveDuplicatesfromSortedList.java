/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicatesShort(ListNode head) {
        if(head==null) return null;
        ListNode p = head;
        
        while(p!=null){
           while(p.next!=null && p.val == p.next.val){
               p.next = p.next.next;
           }
           p = p.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode p = head;
        
        while(p.next!=null){
            if(p.val!=p.next.val){
                p = p.next;
            }else{
                ListNode q = p.next;
                while(q!=null && q.val==p.val){
                    q = q.next;
                }
                p.next = q;
            }
        }
        return head;
    }
}

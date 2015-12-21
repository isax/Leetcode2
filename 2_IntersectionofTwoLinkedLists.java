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
        ListNode p = headA, q = headB;
        
        int l1 = 0, l2 = 0;
        
        while(p!=null){
            l1++;
            p = p.next;
        }
        
        while(q!=null){
            l2++;
            q = q.next;
        }
        
        int diff = Math.abs(l1-l2);
        ListNode longer = l1>l2?headA:headB;
        while(diff!=0){
            longer = longer.next;
            diff--;
        }
        ListNode shorter = l1>l2?headB:headA;
        
        while(longer!=shorter && shorter!=null){
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }
}

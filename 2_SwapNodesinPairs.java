/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            ListNode next = cur.next.next;
            
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            
            prev = cur;
            cur = next;
        }
        return dummy.next;
    }
}

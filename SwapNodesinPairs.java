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
        ListNode dumpHead = new ListNode(0);
        dumpHead.next = head;
        ListNode cur = dumpHead;
        
        while(cur !=null && cur.next!=null && cur.next.next != null){
            ListNode tmp = cur.next.next.next;
            
            ListNode next = cur.next;
            cur.next = next.next;
            cur.next.next = next;
            next.next = tmp;
            
            cur = cur.next.next;
        }
        
        return dumpHead.next;
    }
}

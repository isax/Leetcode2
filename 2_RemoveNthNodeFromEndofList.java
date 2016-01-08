/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy, slow = dummy;
        for(int i = 0; i<n; i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}

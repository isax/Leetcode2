/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        while(head!=null){
            // check if there is enough k nodes left
            int count = 0;
            ListNode next = head;
            while(next!=null && count!=k){
                count++;
                if(count==k){
                    ListNode temp = next.next;
                    next.next = null;
                    next = temp;
                }else{
                    next = next.next;
                }
            }
            if(count!=k) break; // not enough nodes to reverse, quit
            
            prev.next = reverse(head);
            head.next = next;
            prev = head;
            head = next;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}

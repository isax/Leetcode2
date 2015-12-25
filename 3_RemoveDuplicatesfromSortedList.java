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
        
        while(head!=null){
            ListNode next = head.next;
            while(next!=null && next.val==head.val){
                next = next.next;
            }
            
            if(head.next!=next){// there are duplicates
                head.next = next;
            }
            
            head = head.next;
        }
        return dummy.next;
    }
}

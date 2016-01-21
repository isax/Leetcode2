/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode evenDummy = new ListNode(0);
        ListNode oddDummy = new ListNode(0);
        ListNode even = evenDummy;
        ListNode odd = oddDummy;
        
        while(head!=null){
            even.next = head;
            even = even.next;
            odd.next = head.next;
            odd = odd.next;
            
            if(head.next!=null){
                head = head.next.next;
            }else{
                head = null;
            }
        }
        even.next = oddDummy.next;
        return evenDummy.next;
    }
}

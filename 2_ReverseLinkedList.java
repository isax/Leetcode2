/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseListIterative(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode p = head;
        ListNode nextNode = head.next;
        head.next = null;
        
        while(nextNode!=null){
            ListNode temp = nextNode.next;
            nextNode.next = p;
            p = nextNode;
            nextNode = temp;
        }
        return p;
    }
    
    // recursive
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null; // otherwise cycle
        
        return node;
    }
}

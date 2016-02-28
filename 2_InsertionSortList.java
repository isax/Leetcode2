/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode dummy = new ListNode(0);
        
        while(head!=null){
            ListNode temp = dummy;
            while(temp.next!=null && head.val>=temp.next.val){
                temp = temp.next;
            }
            ListNode next = head.next;
            
            head.next = temp.next;
            temp.next = head;
            head = next;
            
        }
        return dummy.next;
    }
    
    public ListNode insertionSortList2(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = head.next;
        dummy.next.next = null;
        
        while(head!=null){
            ListNode temp = dummy;
            while(temp.next!=null && head.val>=temp.next.val){
                temp = temp.next;
            }
            ListNode next = temp.next;
            temp.next = head;
            head = head.next;
            temp.next.next = next;
            
        }
        return dummy.next;
    }
}

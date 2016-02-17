/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode largerHead = new ListNode(0);
        ListNode less = lessHead, larger = largerHead;
        
        while(head!=null){
            if(head.val<x){
                less.next = head;
                less = less.next;
            }else{
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }
        less.next = largerHead.next;
        larger.next = null;
        return lessHead.next;
    }
}

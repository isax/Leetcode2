/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1; ListNode q = l2;
        ListNode curNode = new ListNode(0);
        ListNode head = curNode;
        
        while(p!=null && q!=null){
            if(p.val<=q.val){
                curNode.next = p;
                p = p.next;
            }else{
                curNode.next = q;
                q = q.next;
            }
            curNode = curNode.next;
        }
        curNode.next = p==null ? q:p;
        return head.next;
    }
}

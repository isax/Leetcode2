/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/21144553
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode node = head;
        
        while(node!=null){
            ListNode next = node.next;
            
            ListNode pre = dummy;
            while(pre.next!=null && pre.next.val<node.val){
                pre = pre.next;
            }
            
            node.next = pre.next;
            pre.next = node;
            node = next;
        }
        return dummy.next;
    }
    
    public ListNode insertionSortListMine(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode node = head;
        while(node!=null){
            ListNode next = node.next;
            
            ListNode prev = dummy;
            ListNode q = dummy.next;
            if(node!=q){
                while(q!=null && node.val>q.val){
                    prev = prev.next;
                    q = q.next;
                }
                if(q!=null){
                    prev.next = node;
                    node.next = q;
                }else{
                    prev.next = node;
                    node.next = null;
                }
            }else{
                node.next = null;
            }
            node = next;
        }
        return dummy.next;
    }
}

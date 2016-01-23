/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroupMine(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(prev!=null){
             ListNode nextSegHead = prev.next;
             int count = 0;
             while(count!=k){
                 if(nextSegHead==null) break;
                 count++;
                 nextSegHead = nextSegHead.next;
             }
             if(count<k) break; // not enough nodes 
             
             ListNode segHead = null;
             ListNode cur = prev.next;
             while(cur!=nextSegHead){
                 ListNode temp = cur.next;
                 cur.next = segHead;
                 segHead = cur;
                 
                 cur = temp;
             }
             
             prev.next.next = nextSegHead;
             ListNode temp = prev.next;
             prev.next = segHead;
             prev = temp;
        }
        return dummy.next;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(prev!=null){
             ListNode nextSegHead = prev.next;
             int count = 0;
             while(count!=k && nextSegHead!=null){
                 count++;
                 nextSegHead = nextSegHead.next;
             }
             if(count<k) break; // not enough nodes 
             
             ListNode segHead = reverse(prev.next, nextSegHead); //reverse
             
             prev.next.next = nextSegHead;
             ListNode temp = prev.next;
             prev.next = segHead;
             prev = temp;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode start, ListNode nextSegHead){
        ListNode segHead = null;
        while(start!=nextSegHead){
            ListNode temp = start.next;
            start.next = segHead;
            segHead = start;
            
            start = temp;
        }
        return segHead;
    }
}

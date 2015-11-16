/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    // https://leetcode.com/discuss/15733/share-my-14-lines-c-solution
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int diff = n - m;
        
        ListNode pre = dummy;
        while(m>1){
            pre = pre.next;
            m--;
        }
        
        ListNode cur = pre.next;
        while(diff-->0){
            ListNode next = cur.next;
            
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        
        return dummy.next;
    }
    
    public ListNode reverseBetweenMine(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int diff = n - m;
        
        ListNode slow = dummy;
        while(m>1){
            slow = slow.next;
            m--;
        }
        
        ListNode prev = slow.next;
        ListNode fast = prev!=null?prev.next:null;
        while(diff>0){
            ListNode nextnext = fast.next;
            fast.next = prev;
            prev = fast;
            fast = nextnext;
            diff--;
        }
        
        slow.next.next = fast;
        slow.next = prev;
        
        return dummy.next;
    }
}

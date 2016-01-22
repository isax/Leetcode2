/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // https://leetcode.com/discuss/1709/have-pretty-mergesort-method-anyone-speed-reduce-memory-usage
    // http://blog.csdn.net/linhuanmars/article/details/21133949
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode slow = head, fast = head.next.next; // fast = head; WRONG
        // have to set fast as different with slow at the beginning, otherwise stack overflow when [2,1]
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        
        return merge(sortList(head), sortList(second));
    }
    
    private ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                cur.next = h1;
                h1 = h1.next;
            }else{
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        cur.next = h1==null?h2:h1;
        return dummy.next;
    }
}

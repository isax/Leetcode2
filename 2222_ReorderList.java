/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/21503215
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode halfHead = slow.next;
        slow.next = null;
        
        // reverse second half;
        ListNode reversedHalfHead = reverse(halfHead);
        
        while(reversedHalfHead!=null){
            ListNode next = head.next;
            ListNode reversedHalfNext = reversedHalfHead.next;
            
            head.next = reversedHalfHead;
            head.next.next = next;
            
            head = next;
            reversedHalfHead = reversedHalfNext;
        }
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    
    // https://leetcode.com/discuss/29644/share-a-consise-recursive-solution-in-c
    public void reorderListStackOverFlow(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node!=null){
            count++;
            node = node.next;
        }
        helper(head, count);
    }
    
    private ListNode helper(ListNode node, int count){
        if(count==0) {
            return null;
        }
        if(count==1) {
            return node;
        }
        if(count==2){
            return node.next;
        }
        
        ListNode last = helper(node.next, count-2);
        ListNode newLast = last.next;
        
        last.next = last.next.next;
        newLast.next = node.next;
        node.next = newLast;
        return last;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // reverse from slow
        ListNode curHead = null;
        ListNode next = slow;
        
        while(next!=null){
            ListNode temp = next.next;
            next.next = curHead;
            curHead = next;
            next = temp;
        }
        
        while(curHead!=null){
            if(head.val!=curHead.val) return false;
            head = head.next;
            curHead = curHead.next;
        }
        return true;
    }
}

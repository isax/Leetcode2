/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // https://leetcode.com/discuss/9533/share-my-java-solution-with-explanation
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int len = 0;
        ListNode fast = dummy;
        while(fast.next!=null){
            len++;
            fast = fast.next;
        }
        
        ListNode slow = dummy;
        for(int i = len-k%len; i>0; i--){
            slow = slow.next;
        }
        
        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
    }
    
    public ListNode rotateRightMine(ListNode head, int k) {
        if(head==null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int len = 0;
        ListNode node = head;
        while(node!=null){
            node = node.next;
            len++;
        }
        
        k = k%len;
        //if(k==0) return head;
        
        ListNode slow = head, fast = head;
        for(; k>0; k--){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        fast.next = head;
        dummy.next = slow.next;
        slow.next = null;
        
        //dummy.next = slow.next;
        //slow.next = null;
        //fast.next = head; not working when slow==fast
        
        return dummy.next;
    }
}

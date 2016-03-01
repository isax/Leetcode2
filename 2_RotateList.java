/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int len = 0;
        ListNode node = dummy;
        while(node.next != null){
            len++;
            node = node.next;
        }
        
        k = k%len;
        
        ListNode slow = dummy;
        for(int i = 0; i<len-k; i++){
            slow = slow.next;
        }
        node.next = head;
        dummy.next = slow.next;
        slow.next = null;
        
        return dummy.next;
    }
    
    public ListNode rotateRightMine(ListNode head, int k) {
        if(head==null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int len = 0;
        ListNode node = head;
        while(node != null){
            len++;
            node = node.next;
        }
        
        k = k%len;
        if(k==0) return head;
        
        ListNode slow = dummy, fast = head;
        for(int i = 0; i<k; i++){
            fast = fast.next;
        }
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode rotate = slow.next;
        slow.next = null;
        
        ListNode cur = dummy;
        while(rotate!=null){
            ListNode temp = rotate.next;
            rotate.next = cur.next;
            cur.next = rotate;
            cur = cur.next;
            rotate = temp;
        }
        return dummy.next;
    }
}

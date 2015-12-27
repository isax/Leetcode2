/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //http://blog.csdn.net/linhuanmars/article/details/21503215
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next=null;
        
        secondHead = reverse(secondHead);
        
        ListNode leftHead = head;
        while(secondHead!=null){
            ListNode temp = secondHead.next;
            secondHead.next = leftHead.next;
            leftHead.next = secondHead;
            
            secondHead = temp;
            leftHead = leftHead.next.next;
        }
    }
    
    private ListNode reverse(ListNode head){
        ListNode curHead = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = curHead;
            curHead = cur;
            cur = temp;
        }
        return curHead;
    }
    
    private ListNode reverseMine(ListNode head){
        if(head==null) return null;
        
        ListNode next = head.next;
        head.next = null;
        while(next!=null){
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }
}

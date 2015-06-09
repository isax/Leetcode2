/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        
        ListNode i = head;
        ListNode j = head.next;
        head.next = null;
        
        while(j!=null){
            ListNode temp = j.next;
            j.next = i;
            
            i = j;
            j = temp;
        }
        
        return i;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        
        ListNode temp = head.next;
        head.next = null;
        
        return recursiveReverse(head, temp);
    }
    
    private ListNode recursiveReverse(ListNode cur, ListNode next){
        if(next==null) return cur;
        
        ListNode temp = next.next;
        next.next = cur;
        
        return recursiveReverse(next, temp);
    }
}

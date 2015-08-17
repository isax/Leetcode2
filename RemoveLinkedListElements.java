/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements2(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head;
        
        while(cur!=null){
            if(cur.val==val){
                if(cur==head){
                    pre = cur.next;
                    cur = cur.next;
                    head = pre;
                }else{
                    pre.next = cur.next;
                    cur = pre.next;
                }
            }else{
                if(cur!=pre){
                    pre = pre.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }
    
    public ListNode removeElements1(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        
        ListNode pre = temp;
        ListNode cur = head;
        
        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                cur = pre.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return temp.next;
    }
}

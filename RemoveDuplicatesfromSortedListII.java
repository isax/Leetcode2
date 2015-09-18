/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // https://leetcode.com/discuss/12724/my-accepted-java-code
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p = fake;
        ListNode cur = head;
        
        while(cur!=null){
            while(cur.next!=null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(p.next==cur) p = p.next;
            else p.next = cur.next;
            
            cur = p.next;
        }
        return fake.next;
    }
    
    public ListNode deleteDuplicatesMine(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p = fake;
        
        while(p!=null &&p.next!= null && p.next.next!=null){
            if(p.next.val == p.next.next.val){
                while(p.next.next!=null && p.next.val == p.next.next.val){
                    p.next = p.next.next;
                }
                p.next = p.next.next;
            }
            else p = p.next;
        }
        return fake.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        helper(l1, l2, 0, dummy);
        return dummy.next;
    }
    
    private void helper(ListNode l1, ListNode l2, int add, ListNode l){
        if(l1==null&&l2==null&&add==0) return;
        int sum = add;
        if(l1!=null) sum += l1.val;
        if(l2!=null) sum += l2.val;
        
        add = sum/10;
        sum = sum%10;
        ListNode newNode = new ListNode(sum);
        if(l!=null) l.next = newNode;
        helper(l1!=null?l1.next:null, l2!=null?l2.next:null, add, newNode);
    }
}

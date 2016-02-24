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
        ListNode node = dummy;
        
        int add = 0;
        while(l1!=null || l2!=null || add!=0){
            int i = l1!=null?l1.val:0;
            int j = l2!=null?l2.val:0;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            int sum = i + j + add;
            
            node.next = new ListNode(sum%10);
            add = sum/10;
            node = node.next;
        }
        return dummy.next;
    }
}

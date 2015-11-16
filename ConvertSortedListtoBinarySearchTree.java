/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // no dummy head
    // https://leetcode.com/discuss/58428/recursive-construction-using-slow-fast-traversal-linked-list
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev!=null) prev.next = null;
        else head = null;
        
        TreeNode root = new TreeNode(slow.val);
        
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(slow.next);
        root.left = left; root.right = right;
        return root;
    }
    
    public TreeNode sortedListToBSTMine(ListNode head) {
        if(head==null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = dummy;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            prev = prev.next;
        }
        ListNode next = slow.next;
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        
        TreeNode left = sortedListToBST(dummy.next);
        TreeNode right = sortedListToBST(next);
        root.left = left; root.right = right;
        return root;
    }
}

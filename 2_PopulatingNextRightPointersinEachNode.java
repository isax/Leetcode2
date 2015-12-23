/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null || root.left==null)  return;
        TreeLinkNode head = root;
        
        while(root!=null && root.left!=null){
            TreeLinkNode temp = root;
            while(temp!=null){
                temp.left.next = temp.right;
                if(temp.next!=null) temp.right.next = temp.next.left;
                temp = temp.next;
            }
            root = root.left;
        }
    }
}

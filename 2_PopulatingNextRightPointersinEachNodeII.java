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
        
        TreeLinkNode head = root;
        
        while(head!=null){
            TreeLinkNode temp = head;
            TreeLinkNode lastNode = null;
            TreeLinkNode newHead = null;
            while(temp!=null){
                if(temp.left!=null){
                    if(lastNode!=null){
                        lastNode.next = temp.left;
                    }else{
                        newHead = temp.left;
                    }
                    lastNode = temp.left;
                }
                
                if(temp.right!=null){
                    if(lastNode!=null){
                        lastNode.next = temp.right;
                    }else{
                        newHead = temp.right;
                    }
                    lastNode = temp.right;
                }
                temp = temp.next;
            }
            head = newHead;
        }
    }
}

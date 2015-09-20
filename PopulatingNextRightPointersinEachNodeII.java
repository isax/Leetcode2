/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // code ganker: http://codeganker.blogspot.com/2014/04/populating-next-right-pointers-in-each_11.html
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        
        TreeLinkNode lastHead = root;
        
        while(lastHead!=null){
            TreeLinkNode cur = lastHead;
            TreeLinkNode curHead = null;
            TreeLinkNode pre = null;
            
            while(cur!=null){
                if(cur.left!=null){
                    if(curHead==null){
                        curHead = cur.left;
                        pre = curHead;
                    }else{
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                
                if(cur.right!=null){
                    if(curHead==null){
                        curHead = cur.right;
                        pre = curHead;
                    }else{
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            lastHead = curHead;
        }
    }
    
    public void connectMy(TreeLinkNode root) {
        if(root==null) return;
        
        TreeLinkNode lastHead = root;
        
        while(lastHead!=null){
            TreeLinkNode dummyHead = new TreeLinkNode(0);
            TreeLinkNode cur = dummyHead;
            
            TreeLinkNode nextNodeWithChild = getNextNodeWithChild(lastHead);
            
            while(nextNodeWithChild!=null){
                if(nextNodeWithChild.left!=null) {
                    cur.next = nextNodeWithChild.left;
                    if(nextNodeWithChild.right!=null){
                        cur.next.next = nextNodeWithChild.right;
                    }
                }
                else cur.next = nextNodeWithChild.right;
                
                if(cur.next.next!=null) cur = cur.next.next;
                else cur = cur.next;
                
                nextNodeWithChild = getNextNodeWithChild(nextNodeWithChild.next);
            }
            
            lastHead = dummyHead.next;
        }
    }
    
    private TreeLinkNode getNextNodeWithChild(TreeLinkNode node){
        while(node!=null){
            if(node.left!=null || node.right!=null) return node;
            node = node.next;
        }
        return null;
    }
}

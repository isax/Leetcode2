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
    // http://blog.csdn.net/linhuanmars/article/details/24566995
    public void recoverTree(TreeNode root) {
        TreeNode []prev = new TreeNode[1];
        TreeNode[] toSwap = new TreeNode[2];
        
        helper(root, prev, toSwap);
        int temp = toSwap[0].val;
        toSwap[0].val = toSwap[1].val;
        toSwap[1].val = temp;
    }
    
    private void helper(TreeNode root, TreeNode []prev, TreeNode[] toSwap){
        if(root==null) return;
        helper(root.left, prev, toSwap);
        
        if(prev[0]!=null && prev[0].val>root.val){
            if(toSwap[0]==null){
                toSwap[0] = prev[0];
                toSwap[1] = root; /////////////////////
            }else{
                toSwap[1] = root;
                return;
            }
        }
        prev[0] = root;
        helper(root.right, prev, toSwap);
    }
}

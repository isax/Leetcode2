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
    
    // http://blog.csdn.net/linhuanmars/article/details/23810735
    private class PrevNode{
        Integer prev;
    }
    
    public boolean isValidBST(TreeNode root) {
        PrevNode p = new PrevNode();
        return helper2(root, p);
    }
    
    private boolean helper2(TreeNode root, PrevNode p){
        if(root==null) return true;
        
        boolean left = helper2(root.left, p);
        if(p.prev!=null && root.val<=p.prev){
            return false;
        }
        p.prev = root.val;
        return left && helper2(root.right, p);
    }
    
    // [-2147483648,null,2147483647] won't pass
    public boolean isValidBSTMine(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, int lower, int upper){
        if(root==null) return true;
        
        if(root.val<=lower || root.val>=upper) return false;
        
        /*if(root.left!=null && root.val<=root.left.val){
            return false;
        }
        
        if(root.right!=null && root.val>=root.right.val){
            return false;
        }*/
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
}

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
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/23731355
    public boolean isBalanced(TreeNode root) {
        return helperCG(root)!=-1?true:false;
    }
    private int helperCG(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = helperCG(root.left);
        int right = helperCG(root.right);
        if(left!=-1 && right!=-1 && Math.abs(left-right)<=1){
            return Math.max(left,right)+1;
        }else{
            return -1;
        }
    }
    
    // Min: which is not necessary tp create a new class
    public boolean isBalancedMine(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    private Balance helper(TreeNode root){
        if(root==null) return new Balance(0, true);
        if(root.left==null && root.right==null) {
            return new Balance(1, true);
        }
        
        Balance left = helper(root.left);
        Balance right = helper(root.right);
        
        if(left.isBalanced && right.isBalanced && Math.abs(left.depth-right.depth) <= 1){
            return new Balance(Math.max(left.depth, right.depth)+1, true);
        } else{
            return new Balance(-1, false);
        }
    }
    
    private static class Balance{
        int depth;
        boolean isBalanced;
        
        Balance(int depth, boolean isBalanced){
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
}

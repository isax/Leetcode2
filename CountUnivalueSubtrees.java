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
    // https://leetcode.com/discuss/68057/very-easy-java-solution-post-order-recursion
    public int countUnivalSubtrees(TreeNode root) {
        int [] count = new int[1];
        help(count, root);
        return count[0];
    }
    
    private boolean help(int[] count, TreeNode root){
        if(root==null) return true;
        
        boolean left = help(count, root.left);
        boolean right = help(count, root.right);
        if(left&&right){
            if((root.left==null||root.left.val==root.val) && (root.right==null||root.right.val==root.val)){
                count[0]++;
                return true;
            }
        }
        return false;
    }
    
    // Mine
    public int countUnivalSubtreesMine(TreeNode root) {
        return helper(root).num;
    }
    
    private Pair helper(TreeNode root){
        if(root==null) return new Pair(0, true);
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int count = left.num+right.num;
        
        if(left.isUni&&right.isUni){
            if( (root.left==null||root.left.val==root.val) && (root.right==null||root.right.val==root.val)){
                return new Pair(count+1, true);
            }
        }
        
        return new Pair(count, false);
    }
    
    private static class Pair{
        int num;
        boolean isUni;
        
        public Pair(int num, boolean isUni){
            this.num = num;
            this.isUni = isUni;
        }
    }
}

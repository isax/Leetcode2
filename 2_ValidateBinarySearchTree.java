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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, TreeNode upper, TreeNode lower){
        if(root==null) return true;
        
        if((upper==null || root.val<upper.val) && (lower==null || root.val>lower.val)){
            return helper(root.left, root, lower) && helper(root.right, upper, root);
        }else{
            return false;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, Double.POSITIVE_INFINITYM, Double.NEGATIVE_INFINITY);
    }
    
    private boolean helper(TreeNode root, double upper, double lower){
        if(root==null) return true;
        
        if(root.val>=upper || root.val<=lower){
            return false;
        }else{
            return helper(root.left, root.val, lower) && helper(root.right, upper, root.val);
        }
    }
}

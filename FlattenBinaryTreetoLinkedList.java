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
    // Another Iterative: https://leetcode.com/discuss/36732/8ms-non-recursive-no-stack-c-solution
    public void flatten(TreeNode root) {
        
        while(root!=null){
            if(root.left!=null && root.right!=null){
                TreeNode l = root.left;
                while(l.right!=null){
                    l = l.right;
                }
                l.right = root.right;
            }
            
            if(root.left!=null) root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }
    
    // Another recursion: https://leetcode.com/discuss/46629/my-recursive-solution-is-easy-and-clean
    public void flattenClean(TreeNode root) {
        if(root==null) return;
        
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        
        root.right = root.left;
        root.left = null;
        
        while(root.right!=null){
            root = root.right;
        }
        root.right = right;
    }
    
    // Mine
    public void flattenMy(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if(root==null || root.left==null && root.right==null) return root;
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        TreeNode rootRight = root.right;
        
        if(leftLast!=null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
            return rootRight==null?leftLast:rightLast;
        }else{
            return rightLast;
        }
        
    }
}

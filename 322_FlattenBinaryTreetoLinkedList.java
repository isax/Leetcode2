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
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode left = root.left;
                while(left.right!=null){
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            /*if(root.left!=null) {
                root.right = root.left;
                root.left = null;
            }*/
            root = root.right;
        }
    }
    
    public void flattenMine(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if(root==null || root.left==null && root.right==null) return root;
        
        TreeNode leftEnd = helper(root.left);
        TreeNode rightCopy = root.right;
        if(leftEnd!=null){
            root.right = root.left;
            root.left = null; // forgot this
            leftEnd.right = rightCopy;
        }
        TreeNode rightEnd = helper(rightCopy);
        
        return rightEnd!=null?rightEnd:leftEnd;
    }
}

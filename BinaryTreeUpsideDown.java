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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        if(root.left==null) return root;
        /*if(root.left.left==null) {
            root.left.left = root.right;
            root.left.right = root;
            TreeNode node = root.left;
            root.left = null;
            root.right = null;
            return node;
        }*/
        TreeNode leftHead = null;
        
        leftHead = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return leftHead;
    }
}

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[]inorder, int inl, int inr, int [] postorder, int postl, int postr){
        if(inl==inr) return new TreeNode(inorder[inl]);
        if(inl>inr) return null; 
        
        int root = postorder[postr];
        TreeNode node = new TreeNode(root);
        
        // O(nlogn)
        int inRoot = inl;
        for(; inRoot<=inr; inRoot++){
            if(inorder[inRoot]==root){
                break;
            }
        }
        
        node.left = helper(inorder, inl, inRoot-1, postorder, postl, postl+inRoot-1-inl);
        node.right = helper(inorder, inRoot+1, inr, postorder, postl+inRoot-inl, postr-1);
        return node;
        
    }
}

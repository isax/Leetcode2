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
    public int minDepth(TreeNode root) {
       if(root==null) return 0;
       return helper(root);
    }
    
    private int helper(TreeNode root){
        if(root.left==null && root.right ==null) return 1; // leaf node
        
        if(root.left!=null && root.right==null){
            return minDepth(root.left)+1;
        } else if(root.right!=null && root.left==null){
            return minDepth(root.right)+1;
        }else{
            return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
        }
    }
}

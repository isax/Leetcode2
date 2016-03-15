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
    // 315
    public int countNodes(TreeNode root) {
        int h = getLeftHeight(root);
        return helper(root, h);
    }
    public int helper(TreeNode root, int height) {
        if(root==null) return 0;
        
        int rightSubHeight = getLeftHeight(root.right);
        if(rightSubHeight + 1==height){
            return (1<<(height-1)) - 1 + 1 + helper(root.right, rightSubHeight);
        }else{
            return (1<<rightSubHeight) - 1 + 1 + helper(root.left, height-1);
        }
    }
    
    private int getLeftHeight(TreeNode root){
        int count = 0;
        while(root!=null){
            count++;
            root = root.left;
        }
        return count;
    }
    
    
    public int countNodes(TreeNode root) {
        int height = getHeight(root);
        int count = getNodes(root, height);
        return count;
    }
    
    private int getNodes(TreeNode root, int height){
        if(root==null) return 0;
        
        int rightHeight = 1 + getHeight(root.right);
        if(rightHeight==height){
            return (1<<height) + getNodes(root.right, height-1);
        }else{
            return (1<< (height-1))+getNodes(root.left, height-1);
        }
    }
    
}

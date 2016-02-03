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

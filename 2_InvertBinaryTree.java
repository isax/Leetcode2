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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
        }
        return root;
    }
    
    // Iterative
    public TreeNode invertTreeDFS(TreeNode root) {
        if(root==null) return null;
        
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}

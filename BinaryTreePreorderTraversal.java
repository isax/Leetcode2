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
    // recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }
    
    // iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null) return new ArrayList<Integer>();
        
        stack.push(root);
        List<Integer> res = new ArrayList<Integer>();
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return res;
    }
}

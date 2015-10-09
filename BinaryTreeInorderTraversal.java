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
    // Sigh sometimes i just can't recall anything
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

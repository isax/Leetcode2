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
    
    public List<Integer> inorderTraversalMine(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            
            if(!set.contains(node) && node.left!=null){
                stack.push(node.left);
                set.add(node);
            }else{
                stack.pop();
                list.add(node.val);
                if(node.right!=null) stack.push(node.right);
            }
        }
        return list;
    }
}

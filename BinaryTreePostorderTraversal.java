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
    // http://blog.csdn.net/linhuanmars/article/details/22009351
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>(); 
        if(root == null)  {  
            return res;  
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode pre = null;
        
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right!=null && peek.right!=pre){
                    root = peek.right;
                }else{
                    stack.pop();
                    res.add(peek.val);
                    pre = peek;
                }
            }
        }
        return res;
    }
}

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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        
        TreeNode pre = null;//////////////////
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.peek();
            if(top.right!=null && top.right!=pre){/////////////////
                root = top.right;
            }else{
                stack.pop();
                list.add(top.val);
                pre = top;/////////////////
            }
        }
        return list;
    }
}

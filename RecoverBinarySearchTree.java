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
    // http://blog.csdn.net/linhuanmars/article/details/24566995
    public void recoverTree(TreeNode root) {
        List<TreeNode> toSwap = new ArrayList<TreeNode>();
        TreeNode [] pre = new TreeNode[1];
        helper(root, pre, toSwap);
        
        int temp = toSwap.get(0).val;
        toSwap.get(0).val = toSwap.get(1).val;
        toSwap.get(1).val = temp;
    }
    
    private void helper(TreeNode root, TreeNode [] pre, List<TreeNode> toSwap){
        if(root==null) return;
        
        helper(root.left, pre, toSwap);
        if(pre[0]!=null){
            if(pre[0].val>root.val){
                if(toSwap.size()==0){
                    toSwap.add(pre[0]);
                    toSwap.add(root);
                }else{
                    toSwap.set(1, root);
                }
            }
        }
        pre[0] = root;
        helper(root.right, pre, toSwap);
    }
}

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
    public int longestConsecutive2(TreeNode root) {
        if(root==null) return 0;
        int[] max = new int[1];
        helper2(root, root.val, 0, max);
        return max[0];
    }
    
    private void helper2(TreeNode node, int target, int len, int[]max){
        if(node==null){
            return;
        }
        
        if(node.val==target){
            len++;
        }else{
            len = 1;
        }
        max[0] = Math.max(len, max[0]);
        helper2(node.left, node.val+1, len, max);
        helper2(node.right, node.val+1, len, max);
    }
    
    public int longestConsecutiveMine(TreeNode root) {
        int[] max = new int[1];
        helper(root, null, 0, max);
        return max[0];
    }
    
    private void helper(TreeNode node, TreeNode last, int len, int[]max){
        if(node==null){
            return;
        }
        
        if(last==null || node.val-1==last.val){
            len++;
        }else{
            len = 1;
        }
        max[0] = Math.max(len, max[0]);
        helper(node.left, node, len, max);
        helper(node.right, node, len, max);
    }
}

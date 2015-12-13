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
    public int maxPathSum(TreeNode root) {
        int [] max = new int[1];
        max[0] = Integer.MIN_VALUE; // Need it
        helper(root, max);
        return max[0];
    }
    
    private int helper(TreeNode root, int []max){
        if(root==null) return 0;
        
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        
        int local = root.val+ (left>0?left:0) + (right>0?right:0); // need bracket
        if(local>max[0]) max[0] = local;
        return root.val + Math.max(left, right>0?right:0);
    }
}

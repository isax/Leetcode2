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
    // https://leetcode.com/discuss/39005/a-java-concise-solution
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        
        if(root.left==null && root.right==null) return root.val==sum;
        else return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
    
    public boolean hasPathSumMine(TreeNode root, int sum) {
        return backtrack(root, 0, sum);
    }
    
    private boolean backtrack(TreeNode node, int curSum, int sum){
        if(node==null) return false;
        
        curSum += node.val;
        
        /* this is WRONG, this will stop diving at [1,-2],1,-1. need to check leaf first
        if(curSum==sum){
            if(node.left==null && node.right==null) return true;
            else return false;
        }else{
            return backtrack(node.left, curSum, sum) || backtrack(node.right, curSum, sum);
        }*/
        if(node.left==null && node.right==null){
            return curSum==sum;
        }else{
            return backtrack(node.left, curSum, sum) || backtrack(node.right, curSum, sum);
        }
        
    }
}

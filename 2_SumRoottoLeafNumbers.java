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
    public int sumNumbers(TreeNode root) {
        return helper2(root, 0);
    }
    
    private int helper2(TreeNode root, int sum){
        if(root==null) return 0;
        
        sum = sum*10 + root.val;
        
        if(root.left==null && root.right==null){
            return sum;
        }else{
            return helper2(root.left, sum) + helper2(root.right, sum);
        }
    }
    
    public int sumNumbersMine(TreeNode root) {
        int [] res = new int[1];
        helper(root, 0, res);
        return res[0];
    }
    
    private void helper(TreeNode root, int sum, int [] res){
        if(root==null) return;
        if(root.left==null && root.right==null){
            sum = sum*10 + root.val;
            res[0] += sum;
            return;
        }
        
        helper(root.left, sum*10+root.val, res);
        helper(root.right, sum*10+root.val, res);
        
    }
}

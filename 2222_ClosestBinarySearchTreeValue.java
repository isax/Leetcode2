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
    // https://leetcode.com/discuss/60089/clean-and-concise-java-solution
    public int closestValue(TreeNode root, double target) {
        int prev = root.val;
        
        while(root!=null){
            int cur = root.val;
            if(target>root.val){
                root = root.right;
            }else{
                root = root.left;
            }
            prev = Math.abs(prev-target)>Math.abs(cur-target)?cur:prev;
        }
        return prev;
    }
    
    // https://leetcode.com/discuss/54438/4-7-lines-recursive-iterative-ruby-c-java-python
    public int closestValueR(TreeNode root, double target) {
        return helper(root, target, null);
    }
    
    private int helper(TreeNode root, double target, Integer prev){
        if(root==null) return prev;
        
        int kid = target>root.val?helper(root.right, target, root.val):helper(root.left, target, root.val);
        return Math.abs(root.val-target)>Math.abs(kid-target)?kid:root.val;
    }
}

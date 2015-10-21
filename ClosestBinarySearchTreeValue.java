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
        if(root==null) return 0;
        int last = root.val;
        
        while(root!=null){
            last = Math.abs(root.val-target)>Math.abs(last-target)?last:root.val;
            
            root = root.val<target?root.right:root.left;
        }
        return last;
    }
    
    // https://leetcode.com/discuss/54438/4-7-lines-recursive-iterative-ruby-c-java-python
    public int closestValueMine(TreeNode root, double target) {
        return helper(root, target, null);
    }
    
    private int helper(TreeNode root, double target, Integer last){
        if(root==null){
            return last;
        }
        int kid = root.val>target?helper(root.left, target, root.val): helper(root.right, target, root.val);
        
        return Math.abs(root.val-target)>Math.abs(kid-target)?kid:root.val;
    }
}

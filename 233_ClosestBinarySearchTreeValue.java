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
    public int closestValue(TreeNode root, double target) {
        if(root==null) return Integer.MIN_VALUE;
        int [] closest = new int[1];
        closest[0] = root.val;
        helper(root, target, closest);
        return closest[0];
    }
    
    private void helper(TreeNode root, double target, int [] closest){
        if(root==null) return;
        if(root.val==target) {
            closest[0] = root.val;
            return;
        }
        if(Math.abs(target-root.val)<Math.abs(target-closest[0])) closest[0] = root.val;
        if(root.val>target){
            helper(root.left, target, closest);
        }else{
            helper(root.right, target, closest);
        }
    }
}
    
    
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

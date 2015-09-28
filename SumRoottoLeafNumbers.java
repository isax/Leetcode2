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
    // reference: http://codeganker.blogspot.com/2014/04/sum-root-to-leaf-numbers-leetcode.html
    public int sumNumbers(TreeNode root) {
        return helper2(root, 0);
    }
    private int helper2(TreeNode root, int sum){
        if(root==null) return 0;
        
        sum = sum*10+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }else{
            return helper2(root.left, sum) + helper2(root.right, sum);
        }
    }
    
    // Mine: backtracking
    public int sumNumbersMineComplicated(TreeNode root) {
        MyInteger last = new MyInteger(0);
        MyInteger res = new MyInteger(0);
        
        helper(root, last, res);
        return res.i;
    }
    
    private void helper(TreeNode root, MyInteger last, MyInteger res){
        if(root==null) return;
        
        int val = last.i*10 + root.val;
        int oldLast = last.i;
        
        if(root.left==null && root.right==null) {
            res.i += val;
        }else{
            last.i = val;
            helper(root.left, last, res);
            last.i = val;
            helper(root.right, last, res);
            last.i = oldLast;
        }
    }
    
    private static class MyInteger{
        public int i;
        
        public MyInteger(int i){
            this.i = i;
        }
    } 
}

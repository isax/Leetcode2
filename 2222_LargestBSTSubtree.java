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
    //https://leetcode.com/discuss/86027/share-my-o-n-java-code-with-brief-explanation-and-comments
    public int largestBSTSubtree(TreeNode root) {
        if(root==null) return 0;
        int[] max = new int[1];
        max[0] = 1;
        helper(root, max);
        return max[0];
    }
    
    private Result helper(TreeNode root, int[] max){
        if(root==null) { 
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); 
        }
        
        Result left = helper(root.left, max);
        Result right = helper(root.right, max);
        
        if(root.val <= left.upper || root.val >= right.lower || left.size == -1 || right.size == -1){
            return new Result(-1, 0, 0);
        }else{
            int size = left.size + 1 + right.size;
            max[0] = Math.max(max[0], size);
            return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
        }
    }
    
    class Result {
        int size;
        int lower;
        int upper;

        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}

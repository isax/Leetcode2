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
    public int countNodesBruteForce(TreeNode root) {
        if(root==null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    } 
    // Can try some iterative solution here:
    // https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
    public int countNodes(TreeNode root) {
        //if(root==null) return 0;
        
        int leftDepth = countLeftDepth(root);
        int rightDepth = countRightDepth(root);
        
        if(leftDepth==rightDepth) {
            return (1 << leftDepth) - 1; //(int)Math.pow(2, leftDepth)-1;
        }else{
            return 1+ countNodes(root.left) + countNodes(root.right);
        }
    }
    private int countLeftDepth(TreeNode root){
        int depth = 0;
        while(root!=null){
            depth++;
            root = root.left;
        }
        return depth;
    }
    private int countRightDepth(TreeNode root){
        int depth = 0;
        while(root!=null){
            depth++;
            root = root.right;
        }
        return depth;
    }
    
    /** Not working.... */
    /**
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        TreeNode left = root;
        int leftDepth = 0;
        while(left!=null){
            leftDepth++;
            left = left.left;
        }
        
        TreeNode right = root;
        int rightDepth = 0;
        while(right!=null){
            rightDepth++;
            right = right.right;
        }
        
        if(leftDepth==rightDepth) return (int)Math.pow(2, leftDepth) - 1;
        else return (int)Math.pow(2, leftDepth-1) - 1 + countLeaves(root, leftDepth, rightDepth);
    } 
    
    private int countLeaves(TreeNode root, int leftDepth, int rightDepth){
        if(root==null || leftDepth<rightDepth) return 0;
        
        if(leftDepth==rightDepth) return (int)Math.pow(2, leftDepth-1)/2;
        
        TreeNode mid = root.left;
        int midDepth = 1; // root
        while(mid!=null){
            midDepth++;
            mid = mid.right;
        }
        
        if(midDepth==leftDepth){
            TreeNode midPlusOne = root.right;
            int midPlusOneDepth = 1; // root
            while(midPlusOne!=null){
                midPlusOneDepth++;
                midPlusOne = midPlusOne.left;
            }
            return (int)Math.pow(2, leftDepth-1)/2 + countLeaves(root.right, midPlusOneDepth-1, rightDepth-1);
        }else{
            return countLeaves(root.left, leftDepth-1, rightDepth-1);
        }
    }**/
}

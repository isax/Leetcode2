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
    // https://leetcode.com/discuss/87612/why-the-hint-says-the-optimal-runtime-complexity-height-bst
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return Integer.MIN_VALUE;
        int left = count(root.left);
        
        if(k==left+1){
            return root.val;
        }else if(k>left+1){
            return kthSmallest(root.right, k-left-1);
        }else{
            return kthSmallest(root.left, k);
        }
    }
    
    private int count(TreeNode root){
        if(root==null) return 0;
        
        return count(root.left) + 1 + count(root.right);
    }
    
    // Iterative!
    public int kthSmallest3(TreeNode root, int k) {
        if(root==null) return -1;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
               stack.push(root);
               root = root.left; 
            }
            
            TreeNode node = stack.pop();
            if(++count==k) return node.val;
            root = node.right;
        }
        return Integer.MIN_VALUE;
    }
    
    public int kthSmallest2(TreeNode root, int k) {
        int [] count= new int[2];
        helper(root, count, k);
        return count[1];
    }
    
    private void helper(TreeNode root, int[]count, int k){
        if(root==null) return;
        
        helper(root.left, count, k);
        count[0]++;
        if(count[0]==k){
            count[1] = root.val;
        }else if(count[0]<k){
            helper(root.right, count, k);
        }
    }
}

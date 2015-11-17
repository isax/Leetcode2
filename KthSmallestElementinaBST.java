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
    // follow up : binary search
    // https://leetcode.com/discuss/43771/implemented-java-binary-search-order-iterative-recursive
    
    // Iterative
    // https://leetcode.com/discuss/68052/two-easiest-in-order-traverse-java
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null) return -1;
        
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode node = stack.pop();
                if(--k==0) return node.val;
                root = node.right;
            }
        }
        return -1;
    }
    
    // Refactored my solution
    // recursive
    public int kthSmallestRefactor(TreeNode root, int k) {
        int[] count = new int[2];
        inorder2(root, count, k);
        return count[1];
    }
    
    private void inorder2(TreeNode root, int[]count, int k){
        if(root==null) return;
        
        inorder2(root.left, count, k);
        count[0]++;
        if(count[0]==k){
            count[1]=root.val;
        }else if(count[0]<k) {
            inorder2(root.right, count, k);
        }
    }
    
    // Mine
    public int kthSmallestMine(TreeNode root, int k) {
        int[] count = new int[1];
        inorder(root, count, k);
        return count[0];
    }
    
    private boolean inorder(TreeNode root, int[]count, int k){
        if(root==null) return false;
        
        if(inorder(root.left, count, k)) return true;
        
        if(count[0]==k-1){
            count[0]=root.val;
            return true;
        }else{
            count[0]++;
        }
        if(inorder(root.right, count, k)) return true;
        
        return false;
    }
}

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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = root.val;
        helper(root, max);
        return max[0];
    }
    
    private int helper(TreeNode node, int [] max){
        if(node==null) return 0;
        
        int left = helper(node.left, max);
        int right = helper(node.right, max);
        
        int local = node.val + (left>0?left:0) + (right>0?right:0);
        max[0] = Math.max(max[0], local);
        
        return node.val + Math.max(left, right>0?right:0);
    }
    
    public int maxPathSumMine(TreeNode root) {
        Map<TreeNode, Integer> maxPath = new HashMap<TreeNode, Integer>();
        int[] max = new int[1];
        max[0] = root.val;
        helper2(root, maxPath, max);
        return max[0];
    }
    
    private void helper2(TreeNode node, Map<TreeNode, Integer> maxPath, int [] max){
        if(node==null) return;
        
        helper2(node.left, maxPath, max);
        helper2(node.right, maxPath, max);
        
        int localMax = node.val;
        int maxFull = node.val;
        if(node.left!=null){
            localMax = Math.max(maxPath.get(node.left), 0) + node.val;
            maxFull = Math.max(maxPath.get(node.left), 0) + node.val;
        }
        if(node.right!=null){
            localMax = Math.max(maxPath.get(node.right)+node.val, localMax);
            maxFull = Math.max(maxPath.get(node.right), 0) + maxFull;
        }
        maxPath.put(node, localMax);
        max[0] = Math.max(max[0], maxFull);
    }
}

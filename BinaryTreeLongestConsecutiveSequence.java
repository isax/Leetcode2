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
    
    // https://leetcode.com/discuss/68723/simple-recursive-dfs-without-global-variable
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }
    
    private int dfs(TreeNode node, int local, int parent){
        if(node==null) return local;
        
        if(node.val==parent+1){
            local += 1;
        }else{
            local = 1;
        }
        int left = dfs(node.left, local, node.val);
        int right = dfs(node.right, local, node.val);
        return Math.max(Math.max(left, right), local);
    }
    
    // https://leetcode.com/discuss/66584/easy-java-dfs-is-there-better-time-complexity-solution
    public int longestConsecutive2(TreeNode root) {
        if(root==null) return 0;
        int[] global = new int[1];
        helper2(root, global, 0, root.val);
        return global[0];
    }
    private void helper2(TreeNode root, int [] global, int local, int target){
        if(root==null) return;
        
        if(root.val!=target){
            local = 1;
        }else{
            local += 1;
        }
        global[0] = Math.max(global[0], local);
        helper2(root.left, global, local, root.val+1);
        helper2(root.right, global, local, root.val+1);
    }
    
    // Mine
    public int longestConsecutiveMine(TreeNode root) {
        int[] global = new int[1];
        helper(root, global, 0, null);
        return global[0];
    }
    private void helper(TreeNode root, int [] global, int local, TreeNode parent){
        if(root==null) return;
        
        if(parent==null || root.val!=parent.val+1){
            local = 1;
        }else{
            local += 1;
        }
        global[0] = Math.max(global[0], local);
        helper(root.left, global, local, root);
        helper(root.right, global, local, root);
    }
}

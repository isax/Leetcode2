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
    public int rob(TreeNode root) {
        int [] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] dfs(TreeNode root){
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[1], left[0]) + Math.max(right[0], right[1]);
        return res;
    }
    
    Map<TreeNode, Integer> cache = new HashMap<TreeNode, Integer>();
    public int robMine(TreeNode root) {
        if(root==null) return 0;
        
        if(cache.containsKey(root)){
            return cache.get(root);
        }
        
        int children = rob(root.left) + rob(root.right);
        int grandChildren = 0;
        if(root.left!=null){
            grandChildren += rob(root.left.left);
            grandChildren += rob(root.left.right);
        }
        if(root.right!=null){
            grandChildren += rob(root.right.left);
            grandChildren += rob(root.right.right);
        }
        int max = Math.max(grandChildren + root.val, children);
        cache.put(root, max);
        return max;
    }
}

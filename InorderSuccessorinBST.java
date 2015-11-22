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
    
    // https://leetcode.com/discuss/59787/share-my-java-recursive-solution 
    // also good
    
    // https://leetcode.com/discuss/61105/java-python-solution-o-h-time-and-o-1-space-iterative
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null || p==null) return null;
        
        TreeNode lastVisited = null;
        while(root!=null){
            if(root.val>p.val){
                lastVisited = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return lastVisited;
    }
}

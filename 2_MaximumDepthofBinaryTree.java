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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
    
    public int maxDepthBFS(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int levelNum = 1;
        int depth = 0;
        int nextLevelNum = 0;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                q.offer(node.left);
                nextLevelNum++;
            }
            if(node.right!=null){
                q.offer(node.right);
                nextLevelNum++;
            }
            if(--levelNum==0){
                levelNum = nextLevelNum;
                nextLevelNum = 0;
                depth++;
            }
        }
        return depth;
    }
}

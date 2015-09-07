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
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left, right);
    }
    
    public int maxDepthIteration(TreeNode root) {
        if(root==null) return 0;
        
        Queue<TreeNode> queue  = new LinkedList<TreeNode>();
        
        queue.add(root);
        int lastLevelNumOfNodes = 1;
        int level = 0;
        
        while(!queue.isEmpty()){
            level++;
            int curLevelNumOfNodes = 0;
            
            for(int i = 1; i<=lastLevelNumOfNodes; i++){ // iterate in the current level
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    curLevelNumOfNodes++;
                }
                
                if(node.right!=null){
                    queue.offer(node.right);
                    curLevelNumOfNodes++;
                }
            }
            lastLevelNumOfNodes = curLevelNumOfNodes;
        }
        return level;
    }
    
}

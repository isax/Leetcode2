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
    // 233
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        
        int minDepth = Integer.MAX_VALUE;
        if(root.left!=null) minDepth = Math.min(minDepth, minDepth(root.left));
        if(root.right!=null) minDepth = Math.min(minDepth, minDepth(root.right));
        return minDepth + 1;
    }
    
    public int minDepthBFS(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left==null && node.right==null){
                    return level;
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            level++;
        }
        return -1;
    }
    
    public int minDepthDFS(TreeNode root) {
        if(root==null) return 0;
        
        if(root.left==null && root.right==null) return 1;
        else{
            if(root.left==null){
                return minDepth(root.right)+1;
            }
            if(root.right==null){
                return minDepth(root.left)+1;
            }
            return Math.min(minDepth(root.left), minDepth(root.right))+1;
        }
    }
    
    
    public int minDepthBFS(TreeNode root) {
        if(root==null) return 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int count = 1;
        int nextCount = 0;
        int depth = 1;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            count--;
            
            if(node.left==null && node.right==null){
                break;
            }
            if(node.left!=null) {
                q.offer(node.left);
                nextCount++;
            }
            if(node.right!=null){
                q.offer(node.right);
                nextCount++;
            }
            
            if(count==0){
                count = nextCount;
                nextCount = 0;
                depth++;
            }
        }
        return depth;
    }
}

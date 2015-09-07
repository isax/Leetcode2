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
    public int minDepth(TreeNode root) {
       if(root==null) return 0;
       return helper(root);
    }
    
    private int helper(TreeNode root){
        if(root.left==null && root.right ==null) return 1; // leaf node
        
        if(root.left!=null && root.right==null){
            return minDepth(root.left)+1;
        } else if(root.right!=null && root.left==null){
            return minDepth(root.right)+1;
        }else{
            return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
        }
    }
    
    //Short 1:
    public int minDepth(TreeNode root) {
       if(root==null) return 0;
       int left = minDepth(root.left);
       int right = minDepth(root.right);
       return Math.min(left, right)==0? Math.max(left, right)+1 : Math.min(left,right)+1;
    }
}

/**
 * Iteration
 */
public class Solution {
    public int minDepthIterationLessSpace(TreeNode root) {
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
                if(node.left ==null && node.right==null){
                    // leaf node
                    return level;
                }
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
    
    public int minDepthIterationMoreSpace(TreeNode root) {
        if(root==null) return 0;
        
        Queue<TreeNode> queue  = new LinkedList<TreeNode>();
        Queue<Integer> count = new LinkedList<Integer>();
        
        queue.add(root);
        count.add(1);
        int level = 0;
        
        while(!queue.isEmpty()){
            level++;
            int num = count.poll();
            int numOfChilds = 0;
            
            for(int i = 1; i<=num; i++){ // iterate in the current level
                TreeNode node = queue.poll();
                if(node.left ==null && node.right==null){
                    // leaf node
                    return level;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                    numOfChilds++;
                }
                
                if(node.right!=null){
                    queue.offer(node.right);
                    numOfChilds++;
                }
            }
            count.offer(numOfChilds);
        }
        return level;
    }
}

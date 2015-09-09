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
    // Recursive
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list = new ArrayList<Integer>();
        dfs(root, 1, list);
        return list;
    }
    private void dfs(TreeNode node, int level, List<Integer>list){
        if(node==null) return;
        
        if(list.size()<level) list.add(node.val);
        
        dfs(node.right, level+1, list);
        dfs(node.left, level+1, list);
    }

    // Iterative
    public List<Integer> rightSideViewIterative(TreeNode root) {
        if(root==null) return new ArrayList<Integer>();
        
        List<Integer> res = new ArrayList<Integer>();
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        int numInLevel = 1;
        nodes.offer(root);
        
        while(!nodes.isEmpty()){
            int count = 0;
            for(int n = 1; n <= numInLevel; n++){
                TreeNode node = nodes.poll();
                
                if(node.left!=null){
                    nodes.offer(node.left);
                    count++;
                }
                if(node.right!=null){
                    nodes.offer(node.right);
                    count++;
                }
                if(n==numInLevel){
                    res.add(node.val);
                }
            }
            numInLevel = count;
        }
        return res;
    }
}

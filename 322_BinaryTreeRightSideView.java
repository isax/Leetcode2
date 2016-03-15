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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return Collections.emptyList();
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, 1, list);
        return list;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> list){
        if(root==null) return;
        
        if(list.size()<level){
            list.add(root.val);
        }
        dfs(root.right, level+1, list);
        dfs(root.left, level+1, list);
    }
    
    public List<Integer> rightSideViewBFS(TreeNode root) {
        if(root==null) return Collections.emptyList();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        List<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int count = q.size();
            
            for(int i = 0; i<count; i++){
                TreeNode node = q.poll();
                if(i==count-1) list.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return list;
    }
}

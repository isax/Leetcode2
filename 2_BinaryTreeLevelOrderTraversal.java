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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null) return lists;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int count = queue.size();
            for(; count>0; count--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
    
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null) return lists;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int lastLevelCount = 1;
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int curLevelCount = 0;
            for(; lastLevelCount>0; lastLevelCount--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                    curLevelCount++;
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                    curLevelCount++;
                }
            }
            lastLevelCount = curLevelCount;
            lists.add(list);
        }
        return lists;
    }
}

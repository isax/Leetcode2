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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null) return lists;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll(); 
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                if(flag) list.add(node.val);
                else list.add(0, node.val);
            }
            lists.add(list);
            flag = !flag;
        }
        return lists;
    }
}

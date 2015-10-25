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
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) return lists;
        
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while(size>0){
                TreeNode node = queue.poll();
                if(flag) list.add(node.val);
                else list.add(0, node.val);
                
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                size--;
            }
            flag = !flag;
            lists.add(list);
        }
        return lists;
    }
}

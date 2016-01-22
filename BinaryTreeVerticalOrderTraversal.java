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
    // https://leetcode.com/discuss/75054/5ms-java-clean-solution
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        q.offer(root);
        cols.offer(0);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int col = cols.poll();
            if(!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);
            
            if(node.left!=null) {
                q.offer(node.left);
                cols.offer(col-1);
            }
            
            if(node.right!=null) {
                q.offer(node.right);
                cols.offer(col+1);
            }
        }
        
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for(List<Integer>list : map.values()){
            lists.add(list);
        }
        return lists;
    }
}

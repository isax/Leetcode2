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
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> res = new TreeMap<Integer,List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        if(root==null)  return new ArrayList<List<Integer>>();
        
        q.offer(root);
        cols.offer(0);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){ // same level
                TreeNode node = q.poll();
                int cur = cols.poll();
                if(!res.containsKey(cur)) res.put(cur, new ArrayList<Integer>());
                res.get(cur).add(node.val);
                if(node.left!=null) {
                    q.offer(node.left);
                    cols.offer(cur-1);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    cols.offer(cur+1);
                }
            }
        }
        return new ArrayList<List<Integer>>(res.values());
    }
    
    public List<List<Integer>> verticalOrderMine(TreeNode root) {
        Map<Integer, List<Integer>> res = new TreeMap<Integer,List<Integer>>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, Integer> hm = new HashMap<TreeNode, Integer>();
        if(root==null)  return new ArrayList<List<Integer>>();
        
        q.offer(root);
        hm.put(root, 0);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){ // same level
                TreeNode node = q.poll();
                int cur = hm.get(node);
                if(!res.containsKey(cur)) res.put(cur, new ArrayList<Integer>());
                res.get(cur).add(node.val);
                if(node.left!=null) {
                    q.offer(node.left);
                    hm.put(node.left, cur-1);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    hm.put(node.right, cur+1);
                }
            }
        }
        return new ArrayList<List<Integer>>(res.values());
    }
}

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer p, Integer q){
                if(Math.abs(p-target)>Math.abs(q-target)) return -1; // diff is large should be head to be popped out at any time
                else if (Math.abs(p-target)<Math.abs(q-target)) return 1;
                else return 0;
            }
        });
        
        List<Integer> list = new ArrayList<Integer>();
        helper(root, k, q);
        
        for(int i : q){
            list.add(i);
        }
        return list;
    }
    // need to go through each node... 
    private void helper(TreeNode node, int k, PriorityQueue<Integer> q){
        if(node!=null){
            q.offer(node.val);
            if(q.size()>k) q.poll();
            
            helper(node.left, k, q);
            helper(node.right, k, q);
        }
    }
}

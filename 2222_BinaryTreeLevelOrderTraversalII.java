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
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
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
            ((LinkedList)lists).addFirst(list); // need to do a cast here
        }
        return lists;
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(root==null) return lists;
        
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
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
            stack.push(list); // need to do a cast here
        }
        while(!stack.isEmpty()){
            lists.add(stack.pop());
        }
        return lists;
    }
}

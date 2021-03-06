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
    
    // https://leetcode.com/discuss/55240/ac-clean-java-solution-using-two-stacks
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if(root==null) return new ArrayList<Integer>();
        
        Stack<Integer> predecessors = new Stack<Integer>();
        Stack<Integer> successors = new Stack<Integer>();
        
        inorder(root, predecessors, target);
        reverseInorder(root, successors, target);
        
        List<Integer> list = new ArrayList<Integer>();
        while(k-->0){
            if(predecessors.isEmpty()) {
                list.add(successors.pop());
            }else if(successors.isEmpty()) {
                list.add(predecessors.pop());
            }
            else if(Math.abs((double)predecessors.peek()-target)< Math.abs((double)successors.peek()-target)) {
                list.add(predecessors.pop());
            }else{
                list.add(successors.pop());
            }
        }
        return list;
    }
    
    private void inorder(TreeNode root, Stack<Integer> stack, double target){
        if(root!=null){
            inorder(root.left, stack, target);
            
            if(root.val>target) return;
            stack.push(root.val);
            
            inorder(root.right, stack, target);
        }
    }
    
    private void reverseInorder(TreeNode root, Stack<Integer> stack, double target){
        if(root!=null){
            reverseInorder(root.right, stack, target);
            
            if(root.val<=target) return;
            stack.push(root.val);
            
            reverseInorder(root.left, stack, target);
        }
    }
}

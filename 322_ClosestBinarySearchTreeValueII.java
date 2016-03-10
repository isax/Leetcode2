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
    // 310
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
       Deque<Integer> pre = new LinkedList<>();
       Deque<Integer> post = new LinkedList<>();
       build(root, target, pre, post);
       List<Integer> list = new ArrayList<>();
       for(int i = 0; i<k; i++){
           if(pre.isEmpty()){
               list.add(post.poll());
           }else if(post.isEmpty()){
               list.add(pre.poll());
           }else{
               if(Math.abs(pre.peek()-target)<=Math.abs(post.peek()-target)){
                   list.add(pre.poll());
               }else{
                   list.add(post.poll());
               }
           }
       }
       return list;
    }
    
    private void build(TreeNode root, double target, Deque<Integer> pre, Deque<Integer> post){
        if(root==null){
            return;
        }
        build(root.left, target, pre,post);
        if(root.val <= target){
            pre.addFirst(root.val);
        }else{
            post.add(root.val);
        }
        build(root.right, target, pre, post);
    }
    ///////
    
    
    
    
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> predecessors = new Stack<TreeNode>();
        Stack<TreeNode> successors = new Stack<TreeNode>();
        
        initializePredecessorStack(root, target, predecessors);
        initializeSuccessorStack(root, target, successors);
        if(!successors.isEmpty() && !predecessors.isEmpty() && successors.peek().val == predecessors.peek().val) {
        //while(!successors.isEmpty() && !predecessors.isEmpty() && successors.peek().val == predecessors.peek().val) {
            getPredecessor(predecessors);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<k; i++){
            if(predecessors.isEmpty()){
                list.add(getSuccessor(successors));
            }else if(successors.isEmpty()){
                list.add(getPredecessor(predecessors));
            }else {
                if(Math.abs(predecessors.peek().val-target)<Math.abs(successors.peek().val-target)){
                    list.add(getPredecessor(predecessors));
                }else{
                    list.add(getSuccessor(successors));
                }
            }
        }
        return list;
    }
    
    // only push vals that are > than target
    private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> successors) {
        while(root != null) {
            if(root.val == target) {
                successors.push(root);
                break;
            } else if(root.val > target) {
                successors.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    // whenever found <target, push right node into it
    // so never visited left sub tree
    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> predecessors) {
        while(root != null){
            if(root.val == target){
                predecessors.push(root);
                break;
            } else if(root.val < target){
                predecessors.push(root);
                root = root.right;
            } else{
                root = root.left;
            }
        }
    }
    
    private int getPredecessor(Stack<TreeNode> predecessors){
        TreeNode root = predecessors.pop();
        int res = root.val;
        root = root.left;
        while(root!=null){
            predecessors.push(root);
            root = root.right;
        }
        return res;
    }
    
    private int getSuccessor(Stack<TreeNode> successors){
        TreeNode root = successors.pop();
        int res = root.val;
        root = root.right;
        while(root!=null){
            successors.push(root);
            root = root.left;
        }
        return res;
    }
   
    // https://leetcode.com/discuss/55240/ac-clean-java-solution-using-two-stacks
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> predecessors = new Stack<Integer>();
        Stack<Integer> successors = new Stack<Integer>();
        
        inorder(predecessors, root, target, true);
        inorder(successors, root, target, false);
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<k; i++){
            if(predecessors.isEmpty()){
                list.add(successors.pop());
            }else if(successors.isEmpty()){
                list.add(predecessors.pop());
            }else {
                if(Math.abs(predecessors.peek()-target)<Math.abs(successors.peek()-target)){
                    list.add(predecessors.pop());
                }else{
                    list.add(successors.pop());
                }
            }
        }
        return list;
    }
    
    private void inorder(Stack<Integer> stack, TreeNode root, double target, boolean order){
        if(root==null) return;
        
        inorder(stack, order?root.left:root.right, target, order);
        if(order && root.val>target || !order && target>=root.val) return;
        stack.push(root.val);
        inorder(stack, order?root.right:root.left, target, order);
    }
    
    
    public List<Integer> closestKValuesMine(TreeNode root, double target, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
           public int compare(Integer i, Integer j){
               if(Math.abs(i-target)<Math.abs(j-target)) return 1;
               else if(Math.abs(i-target)>Math.abs(j-target)) return -1;
               else return 0;
           } 
        });
        
        helper(root, queue, k);
        return new ArrayList<Integer>(queue);
    }
    
    private void helper(TreeNode root, Queue<Integer> queue, int k){
        if(root==null) return;
        queue.offer(root.val);
        if(queue.size()>k) queue.poll();
        // need to iterate every node
        helper(root.left, queue, k);
        helper(root.right, queue, k);
    }
}

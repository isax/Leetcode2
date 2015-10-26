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
 
    // https://leetcode.com/discuss/9790/java-solution-with-dp
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> lists = new ArrayList<List<TreeNode>>();
        List<TreeNode> zero = new ArrayList<TreeNode>();
        zero.add(null); 
        lists.add(zero);
        
        for(int i = 0; i<n; i++){
            int curNumber = i+1;
            List<TreeNode> list = new ArrayList<TreeNode>();
            
            for(int root = 1; root<=curNumber; root++){
                for(TreeNode nodeLeft: lists.get(root-1)){// left child node list
                    for(TreeNode nodeRight: lists.get(curNumber-root)){ // right child node list
                        TreeNode leftChild = helper(nodeLeft, 0);
                        TreeNode rightChild = helper(nodeRight, root);
                        TreeNode aRoot = new TreeNode(root);
                        aRoot.left = leftChild; aRoot.right = rightChild;
                        list.add(aRoot);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(n);
    }
    
    private TreeNode helper(TreeNode root, int offset){
        if(root==null) return null;
        TreeNode newRoot = new TreeNode(root.val+offset);
        newRoot.left = helper(root.left, offset);
        newRoot.right = helper(root.right, offset);
        return newRoot;
    }
    
    
    // http://blog.csdn.net/linhuanmars/article/details/24761437
    public List<TreeNode> generateTrees(int n) {
       return helper(1, n);
    }
    
    private List<TreeNode> helper(int s, int e) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        if(s>e) list.add(null);
        
        for(int i = s; i<=e; i++){
            List<TreeNode> left = helper(s, i-1);
            List<TreeNode> right = helper(i+1, e);
            
            for(TreeNode l:left){
                for(TreeNode r: right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }
}

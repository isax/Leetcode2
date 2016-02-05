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
    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> lists = new ArrayList<List<TreeNode>>();
        // so much easier than empty
        List<TreeNode> zero = new ArrayList<TreeNode>();
        if(n==0) return zero;
        zero.add(null); 
        lists.add(zero);
        
        
        for(int i = 1; i<=n; i++){
            List<TreeNode> list = new ArrayList<TreeNode>();
            
            for(int root = 1; root<=i; root++){ // make j as root

                for(TreeNode left : lists.get(root-1)){
                    for(TreeNode right : lists.get(i-root)){
                        TreeNode leftChild = helper(left, 0);
                        TreeNode rightChild = helper(right, root);
                        TreeNode r = new TreeNode(root);
                        r.left = leftChild; 
                        r.right = rightChild;
                        list.add(r);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(n);
    }
    
    private TreeNode helper(TreeNode node, int diff){
        if(node==null) return null;
        
        TreeNode newNode = new TreeNode(node.val+diff);
        newNode.left = helper(node.left, diff);
        newNode.right = helper(node.right, diff);
        return newNode;
    }
    
}

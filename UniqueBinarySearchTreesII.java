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
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        
        if(start>end){
            res.add(null); // a placeholder, if not need to use generateTrees2
            return res;
        }
        
        for(int i = start; i<=end; i++){
            List<TreeNode> leftNodes = generateTrees(start, i-1);
            List<TreeNode> rightNodes = generateTrees(i+1, end);
            
            for(TreeNode leftNode: leftNodes){
                for(TreeNode rightNode: rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
    
    /*
    private List<TreeNode> generateTrees2(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        
        if(start>end){
            return res;
        }
        
        for(int i = start; i<=end; i++){
            List<TreeNode> leftNodes = generateTrees(start, i-1);
            List<TreeNode> rightNodes = generateTrees(i+1, end);
            
            if(leftNodes.isEmpty() && rightNodes.isEmpty()){
                TreeNode root = new TreeNode(i);
                res.add(root);
            }
            
            if(leftNodes.isEmpty()){
                for(TreeNode rightNode: rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.right = rightNode;
                    res.add(root);
                }
            }else if(rightNodes.isEmpty()){
                for(TreeNode leftNode: leftNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    res.add(root);
                }
            } else{
                for(TreeNode leftNode: leftNodes){
                    for(TreeNode rightNode: rightNodes){
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        res.add(root);
                    }
                }
                    
            }
        }
        return res;
    }*/
}

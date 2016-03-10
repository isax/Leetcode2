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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        helper(root, new StringBuilder(), list);
        return list;
    }
    
    private void helper(TreeNode root, StringBuilder sb, List<String>list){
        if(root==null) return;
        
        int oldLen = sb.length();
        if(sb.length()!=0) {
            sb.append("->");
        }
        sb.append(root.val);
        
        if(root.left==null && root.right==null){
            list.add(sb.toString());
            sb.setLength(oldLen);
            return;
        }
        helper(root.left, sb, list);
        helper(root.right, sb, list);
        sb.setLength(oldLen);
    }
    
    // DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        
        if(root==null) return res;
        
        if(root.left==null && root.right==null) {
            res.add(root.val+"");
            return res;
        }
        
        if(root.left!=null) {
            for(String s : binaryTreePaths(root.left)){
                res.add(root.val + "->" + s);
            }
        }
        
        if(root.right!=null){
            for(String s : binaryTreePaths(root.right)){
                res.add(root.val + "->" + s);
            }
        }
        
        return res;
    }
    
    public List<String> binaryTreePathsBacktracking(TreeNode root) {
        List<String>list = new ArrayList<String>();
        helper2(root, new StringBuilder(), list);
        return list;
    }
    
    // better reset?
    private void helper2(TreeNode root, StringBuilder sb, List<String> list){
        if(root==null) return;
        int len = sb.length();
        
        if(root.left==null && root.right==null){
            sb.append(root.val);
            list.add(sb.toString());
            sb.setLength(len);
        }else{
            sb.append(root.val+"->");
            helper2(root.left, sb, list);
            helper2(root.right, sb, list);
            sb.setLength(len);
        }
    }
    
    // reset not pretty
    private void helper(TreeNode root, StringBuilder sb, List<String> list){
        if(root==null) return;
        
        int oldLen = sb.length();
        if(oldLen!=0) sb.append("->");
        sb.append(root.val);
        
        if(root.left==null && root.right==null){
            list.add(sb.toString());
            return;
        }
        
        int len = sb.length();
        
        if(root.left!=null) helper(root.left, sb, list);
        sb.setLength(len);
        
        if(root.right!=null) helper(root.right, sb, list);
        sb.setLength(oldLen);
    }
}

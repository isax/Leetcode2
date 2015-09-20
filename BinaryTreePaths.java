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
    
    // Good recursion: https://leetcode.com/discuss/55451/clean-solution-accepted-without-helper-recursive-function
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root==null) return list;
        
        if(root.left==null && root.right==null){
            list.add(root.val+"");
            return list;
        }
        
        for(String path: binaryTreePaths(root.left)){
            list.add(root.val + "->" + path);
        }
    
        for(String path: binaryTreePaths(root.right)){
            list.add(root.val + "->" + path);
        }
        
        return list;
    }

    // Second recursion:
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root==null) return list;
        
        helper(root, new StringBuilder(), list);
        return list;
    }
    
    // clean up sb
    private void helper(TreeNode root, StringBuilder sb, List<String> list){
        if(root==null) return;
        
        int len = sb.length();
        
        if(root.left==null && root.right==null) {
            sb.append(root.val);
            list.add(sb.toString());
            sb.delete(len, sb.length());
        } else{
            sb.append(root.val+"->");
            helper(root.left, sb, list);
            helper(root.right, sb, list);
            sb.delete(len, sb.length());
        }
    }
    
    // My
    private void myHelper(TreeNode root, StringBuilder sb, List<String> list){
        if(root==null) return;
        
        if(root.left==null && root.right==null) {
            String res = sb.toString() + root.val;
            list.add(res);
        } else{
            StringBuilder nextLevel = new StringBuilder(sb);
            nextLevel.append(root.val+"->");
            helper(root.left, nextLevel, list);
            helper(root.right, nextLevel, list);
        }
    }
}

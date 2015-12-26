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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(root, sum, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helper(TreeNode root, int sum, List<Integer>list, List<List<Integer>>lists){
        if(root==null) return;
        
        list.add(root.val);
        
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                lists.add(new ArrayList<Integer>(list));
            }
            list.remove(list.size()-1);
            return;
        }
        
        helper(root.left, sum-root.val, list,lists);
        helper(root.right, sum-root.val, list, lists);
        list.remove(list.size()-1);
    }
}

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
        if(root==null) return lists;
        helper(root, sum, new ArrayList<Integer>(), lists);
        return lists;
    }
    
    private void helperMine(TreeNode root, int sum, int cur, List<Integer> list, List<List<Integer>> lists){
        if(root.left==null && root.right==null){
            if(cur+root.val==sum){
                list.add(root.val);
                lists.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        
        list.add(root.val);
        if(root.left!=null) helperMine(root.left, sum, cur+root.val, list, lists);
        if(root.right!=null) helperMine(root.right, sum, cur+root.val, list, lists);
        list.remove(list.size()-1);
    }
    
    // http://blog.csdn.net/linhuanmars/article/details/23655413
    private void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> lists){
        if(root.left==null && root.right==null){
            if(sum==root.val){
                list.add(root.val);
                lists.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        
        list.add(root.val);
        if(root.left!=null) helper(root.left, sum-root.val, list, lists);
        if(root.right!=null) helper(root.right, sum-root.val, list, lists);
        list.remove(list.size()-1);
    }
}

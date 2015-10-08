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

    // my recursive thoughts for fun
    // can use stack
    // collection.reverse()
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null) return lists;
        
        List<List<Integer>> left = levelOrderBottom(root.left);
        List<List<Integer>> right = levelOrderBottom(root.right);
        
        int l=left.size()-1;
        int r=right.size()-1;
        
        for(;l>=0 && r>=0; l--, r--){
            left.get(l).addAll(right.get(r));
            right.get(r).clear();
        } 
        while(r>=0){
            left.add(0, right.get(r));
            r--;
        }
        
        List<Integer> rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        left.add(rootList); // add root val
        return left;
    }
}

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    private TreeNode helper(int[] preorder, int a, int b, int[] inorder, int c, int d, Map<Integer, Integer> map){
        if(a>b) return null;
        
        int root = preorder[a];
        TreeNode node = new TreeNode(root);
        int i = map.get(root);
        
        node.left = helper(preorder, a+1, i-c+a, inorder, c, i-1, map);
        node.right = helper(preorder,i-c+a+1 ,b, inorder, i+1, d, map);
        return node;
    }
}

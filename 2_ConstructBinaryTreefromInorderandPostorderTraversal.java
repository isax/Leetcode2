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
    // 02/10
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    private TreeNode helper(int[]preorder, int p, int q, int[]inorder, int i, int j, Map<Integer, Integer> map){
        if(p>q) return null;
        TreeNode root = new TreeNode(preorder[p]);
        if(p==q) return root;
        
        int r = map.get(preorder[p]);
        root.left = helper(preorder, p+1, r-i+p, inorder, i, r-1, map);
        root.right = helper(preorder, r-i+p+1, q, inorder, r+1, j, map);
        return root;
    }

    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[]inorder, int inl, int inr, int [] postorder, int postl, int postr){
        if(inl==inr) return new TreeNode(inorder[inl]);
        if(inl>inr) return null; 
        
        int root = postorder[postr];
        TreeNode node = new TreeNode(root);
        
        // O(nlogn)
        int inRoot = inl;
        for(; inRoot<=inr; inRoot++){
            if(inorder[inRoot]==root){
                break;
            }
        }
        
        node.left = helper(inorder, inl, inRoot-1, postorder, postl, postl+inRoot-1-inl);
        node.right = helper(inorder, inRoot+1, inr, postorder, postl+inRoot-inl, postr-1);
        return node;
        
    }
}

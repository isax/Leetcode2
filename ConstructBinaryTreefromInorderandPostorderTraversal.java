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
    // https://leetcode.com/discuss/15115/my-comprehension-of-o-n-solution-from-%40hongzhi
    // https://leetcode.com/discuss/23834/java-iterative-solution-with-explanation
    
    
    // Code Ganker
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }
        
        return helperCG(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, hm);
    }
    
    private TreeNode helperCG(int[] inorder, int a, int b, int[]postorder, int c, int d, Map<Integer, Integer> map){
        if(a>b) return null;
        
        int root = postorder[d];
        TreeNode node = new TreeNode(root);
        
        int i = map.get(root);
        
        node.right = helper(inorder, i+1, b, postorder,i-a+c,d-1);
        node.left = helper(inorder, a, i-1, postorder, c, i-1-a+c);
        return node;
    }
    
    // Mine
    public TreeNode buildTreeMine(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int a, int b, int[]postorder, int c, int d){
        if(a>b) return null;
        
        int root = postorder[d];
        TreeNode node = new TreeNode(root);
        
        int i = a;
        for(; i<=b; i++){
            if(inorder[i]==root){
                break;
            }
        }
        
        node.right = helper(inorder, i+1, b, postorder,i-a+c,d-1);
        node.left = helper(inorder, a, i-1, postorder, c, i-1-a+c);
        return node;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }
    
    //Prefix - when the String starts with the delimiter, the first element becomes empty String. 
    //String[] items = ",A,B,C".split(",");
    
    //Middle - each additional occurence of the delimiter in the middle of the String will result to a corresponding empty String
    //Suffix - all occurence of the delimiter at the end of the String will be ignored. 
    
    private void helper(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        helper(root.left, sb);
        helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int [] index = new int[1];
        return helper2(nodes, index);
    }
    private TreeNode helper2(String [] nodes, int[]index){
        if(index[0]==nodes.length) return null;
        
        if(nodes[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(nodes[index[0]]));
        index[0]++;
        node.left = helper2(nodes, index);
        node.right = helper2(nodes, index);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

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
    
     private void helper(TreeNode root, StringBuilder sb){
         if(root==null) {
             sb.append("null,");
             return;
         }
         
         sb.append(root.val+",");
         helper(root.left, sb);
         helper(root.right, sb);
     }
     
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
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        root.left = helper2(nodes, index);
        root.right = helper2(nodes, index);
        return root;
    }
    
    // BFS
    // Encodes a tree to a single string.
    public String serializeIterative(TreeNode root) {
        StringBuilder res = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(res.length()!=0) res.append(",");
            
            if(node==null){
                res.append("null");
            }else{
                res.append(node.val);
                q.add(node.left);
                q.add(node.right);
            }
            
        }
        return res.toString();
    }


    // BFS
    // Decodes your encoded data to tree.
    public TreeNode deserializeIterative(String data) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        String[] nodes = data.split(",");
        TreeNode res = parseNode(nodes[0]);
        q.add(res);
        
        int i = 1;
        while(!q.isEmpty() && i<nodes.length){
            TreeNode root = q.poll();
            
            String left = nodes[i++];
            String right = nodes[i++];
            
            root.left = parseNode(left);
            root.right = parseNode(right);
            
            if(root.left!=null) q.offer(root.left);
            if(root.right!=null) q.offer(root.right);
        }
        return res;
    }
    
    private TreeNode parseNode(String node){
        if(node.equals("null")){
            return null;
        }else{
            TreeNode newNode = new TreeNode(Integer.parseInt(node));
            return newNode; 
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

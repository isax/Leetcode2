/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        return bfs(node);
    }
    
    private UndirectedGraphNode bfs(UndirectedGraphNode node){
        if(node==null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.offer(node);
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root); 

        while(!q.isEmpty()){
            UndirectedGraphNode n = q.poll();
            List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
            
            for(UndirectedGraphNode neighbor:n.neighbors){
                 if(!map.containsKey(neighbor)){
                     UndirectedGraphNode copyOfNeighbor = new UndirectedGraphNode(neighbor.label);
                     map.put(neighbor, copyOfNeighbor); 
                     q.offer(neighbor);
                 }
                neighbors.add(map.get(neighbor));
            }
            map.get(n).neighbors = neighbors;
        }
        return root;
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        helper(node, map);
        return root;
    }
    
    private void helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if(node==null) return;
        
        for(UndirectedGraphNode neighbor : node.neighbors){
            if(!map.containsKey(neighbor)){
                UndirectedGraphNode newChild = new UndirectedGraphNode(neighbor.label);
                map.put(neighbor, newChild);
                helper(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
    
    public UndirectedGraphNode cloneGraphDFS2(UndirectedGraphNode node) {
        return dfs2(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    
    private UndirectedGraphNode dfs2(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map){
        if(node==null) return null;
        
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        map.put(node, copyNode);
        for(UndirectedGraphNode neighbor : node.neighbors){
            copyNode.neighbors.add(dfs2(neighbor, map));
        }
        return copyNode;
    }
}

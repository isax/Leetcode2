/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // BFS
    // http://blog.csdn.net/linhuanmars/article/details/22715747
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node==null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        
        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            List<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();
            
            for(UndirectedGraphNode n : cur.neighbors){
                if(!map.containsKey(n))   ///////
                { 
                    UndirectedGraphNode newChild = new UndirectedGraphNode(n.label);
                    map.put(n, newChild);
                    q.offer(n); ///////
                }
                neighbors.add(map.get(n));
            }
            map.get(cur).neighbors = neighbors;
        }
        return root;
    }
    
    // DFS
    // http://blog.csdn.net/linhuanmars/article/details/22715747
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
        
        for(UndirectedGraphNode n : node.neighbors){
            if(!map.containsKey(n)){
                UndirectedGraphNode newChild = new UndirectedGraphNode(n.label);
                map.put(n, newChild);
                helper(n, map);
            }
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

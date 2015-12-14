public class Solution {
    // DFS?
    // https://leetcode.com/discuss/71742/java-o-n-time-o-n-space-solution-using-dfs-30ms
    // https://leetcode.com/discuss/72739/two-o-n-solutions
    
    // Iterative - BFS
    // https://leetcode.com/discuss/71763/share-some-thoughts
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
        for(int i = 0; i<n; i++) adj.add(new HashSet<Integer>());
        
        for(int i = 0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        // get current leaves
        for(int i = 0; i<n; i++){
            if(adj.get(i).size()==1) leaves.add(i);
        }
        
        while(n>2){
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int i : leaves){
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size()==1) newLeaves.add(j);
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }
    
    
    public List<Integer> findMinHeightTreesMine(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for(int i = 0; i<edges.length; i++){
            int smaller = Math.min(edges[i][0], edges[i][1]);
            int larger = Math.max(edges[i][0], edges[i][1]);
            
            if(!map.containsKey(smaller)){
                map.put(smaller, new ArrayList<Integer>());
            }
            map.get(smaller).add(larger);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i<n; i++){
           List<Integer> cur = new ArrayList<Integer>();
           cur.add(i);
           helper(res, cur, i, map); 
        }
        
        List<Integer> list = new ArrayList<Integer>();
        int size = res.get(0).size();
        if(size%2==0){
            list.add(res.get(0).get(size/2-1));
        }
        list.add(res.get(0).get(size/2)); 
        return list;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int curNode, Map<Integer, List<Integer>> map){
        if(!map.containsKey(curNode)){ // leaf
            if(res.isEmpty()) {
                res.add(new ArrayList<Integer>(cur));
            }
            else if(cur.size()>res.get(0).size()){
                res.clear();
                res.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        
        List<Integer> next = map.get(curNode);
        for(int node: next){
            cur.add(node);
            helper(res, cur, node, map);
            cur.remove(cur.size()-1);
        }
    }
}

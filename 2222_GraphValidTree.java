public class Solution {
    // https://github.com/isax/Leetcode2/blob/master/GraphValidTree.java
    public boolean validTree(int n, int[][] edges) {
        int[] uf = new int[n];
        for(int i = 0; i<n; i++){
            uf[i] = i;
        }
        
        for(int i = 0; i<edges.length; i++){
            int x = findRoot(edges[i][0], uf);
            int y = findRoot(edges[i][1], uf);
            
            if(x==y) return false;
            uf[x] = y;
        }
        return edges.length==n-1;
    }
    
    private int findRoot(int i, int [] uf){
        while(uf[i]!=i){
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
    
    public boolean validTreeDFS(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[]edge :edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        if(hasCycle(0, adj, visited, -1)){
            return false;
        }
        
        for(int i = 0; i<n; i++){
            if(!visited[i]) return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(int i, List<List<Integer>> adj, boolean[] visited, int parent){
        visited[i] = true;
        for(int n:adj.get(i)){
            if(visited[n] && n!=parent) return true;
            else if(!visited[n] && hasCycle(n, adj, visited, i)) return true;
        }
        return false;
    }
}

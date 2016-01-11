public class Solution {
    // Has n-1 edges and is acyclic.
    // Has n-1 edges and is connected.
    
    // https://leetcode.com/discuss/52563/ac-java-union-find-solution
    // Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not.
    public boolean validTree (int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        for(int i = 0; i<edges.length; i++){
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            if(x==y) return false;
            nums[x] = y;
        }
        return edges.length==n-1;
    }
    
    private int find(int[]nums, int i){
        if(nums[i]==-1) return i;
        else return find(nums, nums[i]);
    }
    
    // https://leetcode.com/discuss/52541/16-lines-c-dfs: answer use n-1 
    public boolean validTreeDFSEdges (int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        
        // create adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i<edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        dfs(0, adjList, visited);
        
        // check if connected
        for(int i = 0; i<n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    
    private void dfs(int i, List<List<Integer>> adjList, boolean[] visited){
        visited[i] = true;
        for(int neighbor: adjList.get(i)){
            if(!visited[neighbor]) dfs(neighbor, adjList, visited);
        }
    }
    
    
    // https://leetcode.com/discuss/52568/ac-java-graph-dfs-solution-with-adjacency-list
    public boolean validTreeDFS(int n, int[][] edges) {
        // tree: undirected graph, in which two vertices are connected by one path
        // or connected graph without cycle 
        
        // create adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i<edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        
        // Is there a specific reason for keeping two different arrays for "onpath" and "visited"? I think if we have finished DFS on one path, there is no way to visit nodes on this path from nodes on other paths, or it would not be a tree...
        // https://leetcode.com/discuss/52541/16-lines-c-dfs
        boolean[] visited = new boolean[n];
        // check if it has a cycle starting from 0 and connecting
        if(hasCycle(0, adjList, visited, -1)) {
            return false;
        }
        
        // check if connected
        for(int i = 0; i<n; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    
    private boolean hasCycle(int i, List<List<Integer>> adjList, boolean[] visited, int parent){
        visited[i] = true;
        for(int neighbor: adjList.get(i)){
            if(visited[neighbor] && neighbor!=parent) return true;
            else if(!visited[neighbor] && hasCycle(neighbor, adjList, visited, i)) return true;
        }
        return false;
    }
}

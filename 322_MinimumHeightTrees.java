public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Collections.singletonList(0);
        List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
        
        for(int i = 0; i<n; i++){
            adjList.add(new HashSet<Integer>());
        }
        for(int i = 0; i<edges.length; i++){
            int smaller = Math.min(edges[i][0], edges[i][1]);
            int larger = Math.max(edges[i][0], edges[i][1]);
            
            adjList.get(smaller).add(larger);
            adjList.get(larger).add(smaller);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i<n; i++){
            if(adjList.get(i).size()==1) leaves.add(i);
        }
        
        while(n>2){
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int leave : leaves){
                for(int adj : adjList.get(leave)){
                    adjList.get(adj).remove(leave);
                    if(adjList.get(adj).size()==1) newLeaves.add(adj);
                }
            }
            n = n - leaves.size();
            leaves = newLeaves;
        }
        
        return leaves;
    }
}

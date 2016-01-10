public class Solution {
    // bfs:
    // https://leetcode.com/discuss/42543/18-22-lines-c-bfs-dfs-solutions
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        
        // make directed graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] indegrees = new int[numCourses];
        // compute indegree
        for (int i = 0; i < graph.size(); i++) {
            for(int n : graph.get(i)){
                indegrees[n]++;
            }
        }
        
        boolean [] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++)
                if (indegrees[j]==0) break; // find indegree==0
            // didn't find any indegree==0
            if(j==numCourses) return false;
            indegrees[j]=-1;
            
            for(int neighbor : graph.get(j)){
                indegrees[neighbor]--;
            }
        }
        return true;
    }
    
    // https://leetcode.com/discuss/34791/bfs-topological-sort-and-dfs-finding-cycle-by-c
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean [] visited = new boolean[numCourses];
        boolean [] flag = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!flag[i] && detectCycle(i, graph, visited, flag)) return false; // without !flag[i] can pass as well 
        }
        return true;
    }
    
    private boolean detectCycle(int i, List<List<Integer>>graph, boolean[]visited, boolean [] flag){
        flag[i] = true;
        visited[i] = true;
        for(int n : graph.get(i)){
            if(visited[n] || detectCycle(n, graph, visited, flag)) return true;
        }
        visited[i] = false;
        return false;
    }
}

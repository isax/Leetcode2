public class Solution {
    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i<numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<prerequisites.length; i++){
            int p = prerequisites[i][0];
            int q = prerequisites[i][1];
            adjList.get(q).add(p);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(!visited[i] && hasCycle(i, adjList, visited, visiting)) return false;
        }
        return true;
    }
    
    private boolean hasCycle(int i, List<List<Integer>> adjList, boolean[] visited, boolean[] visiting)
    {
        visiting[i] = true;
        for(int next : adjList.get(i)){
            if(visited[next]) continue;
            if(visiting[next] || hasCycle(next, adjList, visited, visiting)) return true;
        }
        visiting[i] = false;
        visited[i] = true;
        return false;
    }
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i<numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        int[] indegrees = new int[numCourses];
        for(int i = 0; i<prerequisites.length; i++){
            int p = prerequisites[i][0];
            int q = prerequisites[i][1]; // must take q before p
            adjList.get(q).add(p);
            indegrees[p]++;
        }
        
        Queue<Integer>q = new LinkedList<Integer>();
        for(int i = 0; i<numCourses; i++){
            if(indegrees[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int i = q.poll();
            for(int next : adjList.get(i)){
                indegrees[next]--;
                if(indegrees[next]==0){
                    q.add(next);
                }
            }
        }
        
        for(int i = 0; i<numCourses; i++){
            if(indegrees[i]!=0) return false;
        }
        return true;
    }
    
}

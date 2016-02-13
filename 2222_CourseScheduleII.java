public class Solution {
    
    // https://leetcode.com/discuss/42548/20-lines-c-bfs-dfs-solutions
    // https://leetcode.com/discuss/35605/two-ac-solution-in-java-using-bfs-and-dfs-with-explanation
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        Stack<Integer>stack = new Stack<Integer>();
        for(int i = 0; i<numCourses; i++){
            if(!visited[i] && hasCycle(i, adjList, visited, visiting, stack)) return new int[0];
        }
        int [] res = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            res[i] = stack.pop();
        }
        return res;
    }
    
    private boolean hasCycle(int i, List<List<Integer>> adjList, boolean[] visited, boolean[] visiting, Stack<Integer>stack)
    {
        visiting[i] = true;
        for(int next : adjList.get(i)){
            if(visited[next]) continue;
            if(visiting[next] || hasCycle(next, adjList, visited, visiting, stack)) return true;
        }
        visiting[i] = false;
        visited[i] = true;
        stack.push(i);
        return false;
    }
    
    // DFS
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
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
        int [] res = new int[numCourses];
        int c = 0;
        while(!q.isEmpty()){
            int i = q.poll();
            res[c++] = i;
            for(int next : adjList.get(i)){
                indegrees[next]--;
                if(indegrees[next]==0){
                    q.add(next);
                }
            }
        }
        
        for(int i = 0; i<numCourses; i++){
            if(indegrees[i]!=0) return new int[0];
        }
        return res;
    }
}

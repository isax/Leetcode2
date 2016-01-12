public class Solution {
    
    // DFS
    // https://leetcode.com/discuss/42548/20-lines-c-bfs-dfs-solutions
    // https://leetcode.com/discuss/35605/two-ac-solution-in-java-using-bfs-and-dfs-with-explanation
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean [] visited = new boolean[numCourses];
        boolean [] flag = new boolean[numCourses]; 
        Deque<Integer> path = new ArrayDeque<Integer>();
        for(int i = 0; i<numCourses; i++){
            if(!flag[i] && dfsCycle(i, graph, visited, flag, path)) return new int[0];
        }
        
        int[] res = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            res[i] = path.pop();
        }
        return res;
    }
    
    private boolean dfsCycle(int cur, List<List<Integer>> graph, boolean [] visited, boolean [] flag, Deque<Integer> path){
        //if(flag[cur]) return false;
        
        flag[cur] = true;
        visited[cur] = true;
        
        for(int neighbor : graph.get(cur)){
            if(visited[neighbor]|| (!flag[neighbor] && dfsCycle(neighbor, graph, visited, flag, path))) return true;
            // if no check flag, [[2,0],[2,1]] will output path [2,0,2,1]
        }
        path.push(cur);
        visited[cur] = false;
        return false;
    }
    
    // BFS
    // better
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        int [] indegrees = new int[numCourses];
        for(int i = 0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        
        Queue<Integer> zeroIndegree = new LinkedList<Integer>();
        for(int j = 0; j<numCourses; j++){
            if(indegrees[j]==0) {
                zeroIndegree.offer(j);
            }
        }
        
        int cur = 0;
        while(!zeroIndegree.isEmpty()){
            int i = zeroIndegree.poll();
            res[cur++] = i;
            
            for(int next : graph.get(i)){
                indegrees[next]--;
                if(indegrees[next]==0) zeroIndegree.offer(next);
            }
        }
        
        if(cur!=numCourses) return new int[0];
        else return res;
    }
    
    
    public int[] findOrder0(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        int [] indegrees = new int[numCourses];
        for(int i = 0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }
        
        int cur = 0;
        for(int i = 0; i<numCourses; i++){
            int j = 0;
            for(; j<numCourses; j++){
                if(indegrees[j]==0) {
                    indegrees[j] = -1;
                    break;
                }
            }
            if(j==numCourses) {
                if(cur==numCourses) break;
                else return new int[0];
            }
            res[cur++] = j;
            
            
            for(int next : graph.get(j)){
                indegrees[next]--;
            }
        }
        return res;
    }
}

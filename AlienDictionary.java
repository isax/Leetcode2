public class Solution {
    // https://leetcode.com/discuss/78602/3ms-clean-java-solution-dfs
    public String alienOrder(String[] words) {
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
        int[] visited = new int[26];
        buildGraphDFS(words, adj, visited);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26; i++){
            if(visited[i]==0){
                if(!dfs(i, adj, visited, sb)) return "";
            }
        }
        return sb.reverse().toString();
    }
    
    private boolean dfs(int i, List<Set<Integer>> adj, int[]visited, StringBuilder sb){
        visited[i] = 1;
        
        for(int next : adj.get(i)){
            if(visited[next]==1) return false;
            if(visited[next]==0) {
                if(!dfs(next, adj, visited, sb)) return false;
            }
            // if visited==2 ignore
        }
        
        visited[i] = 2;
        sb.append((char)('a'+ i));
        return true;
    }
    
    private void buildGraphDFS(String[] words, List<Set<Integer>> adj, int[] visited){
        for(int i = 0; i < 26; i++) adj.add(new HashSet<Integer>());
        Arrays.fill(visited, -1);
        
        for(int i = 0; i<words.length; i++){
            for(char c : words[i].toCharArray()) {
                if(visited[c-'a']==-1) visited[c-'a'] = 0; 
            }
            
            if(i>0){
                int len1 = words[i-1].length();
                int len2 = words[i].length();
                
                for(int j = 0; j<len1 && j<len2; j++){
                    if(words[i-1].charAt(j) != words[i].charAt(j)){
                        int ch1 = words[i-1].charAt(j) - 'a';
                        int ch2 = words[i].charAt(j) - 'a';
                        adj.get(ch1).add(ch2);
                        break;
                    }
                }
            }
        }
    }
    
    // https://leetcode.com/discuss/54549/java-toposort-solution-clean
    // Topological Sort - BFS
    public String alienOrderBFS(String[] words) {
        List<Set<Integer>> adjList = new ArrayList<Set<Integer>>();
        int [] indegrees = new int[26];
        buildGraph(words, adjList, indegrees);
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i<26; i++){
            if(indegrees[i]==0){
                q.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int n = q.poll();
            sb.append((char)('a'+n));
            for(int next : adjList.get(n)){
                if(--indegrees[next]==0) q.offer(next);
            }
        }
        for(int i : indegrees){
            if(i>0) return "";
        }
        return sb.toString();
    }

    private void buildGraph(String[]words, List<Set<Integer>> adjList, int[]indegrees){
        for(int i = 0; i < 26; i++) adjList.add(new HashSet<Integer>());
        Arrays.fill(indegrees, -1);
        
        for(int i = 0; i<words.length; i++){
            for(char c : words[i].toCharArray()) {
                if(indegrees[c-'a']==-1) indegrees[c-'a'] = 0; // !!!!!!
            }
            
            if(i>0){
                int len1 = words[i-1].length();
                int len2 = words[i].length();
                
                for(int j = 0; j<len1 && j<len2; j++){
                    if(words[i-1].charAt(j) != words[i].charAt(j)){
                        int ch1 = words[i-1].charAt(j) - 'a';
                        int ch2 = words[i].charAt(j) - 'a';
                        
                        if(!adjList.get(ch1).contains(ch2)){
                            adjList.get(ch1).add(ch2);
                            indegrees[ch2]++;
                            break;
                        }
                    }
                }
            }
        }
    }
}

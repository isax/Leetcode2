public class Solution {
    public String alienOrder(String[] words) {
        List<Set<Character>> adjList = new ArrayList<Set<Character>>();
        int [] visited = new int[26];
        Arrays.fill(visited, -1);
        buildAdjListDFS(words, adjList, visited);
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<visited.length; i++){
            if(visited[i]==-1 || visited[i]==2) continue;
            
            if(visited[i]==0){
                if(!dfs(i, adjList, visited, res)) return "";
            }
        }
        
        return res.reverse().toString();
    }
    
    private boolean dfs(int i, List<Set<Character>> adjList, int [] visited, StringBuilder sb){
        visited[i] = 1;
        for(char ch : adjList.get(i)){
            if(visited[ch-'a']==1) return false;
            if(visited[ch-'a']==0 && !dfs(ch-'a', adjList, visited, sb)){
                return false;
            }
        }
        visited[i] = 2;
        sb.append((char)('a'+i));////////////////////////
        return true;
    }
    
    private void buildAdjListDFS(String[] words, List<Set<Character>> adjList, int[] visited){
        for(int i = 0; i<26; i++){
            adjList.add(new HashSet<Character>());
        }
            
        for(int n = 0; n<words.length; n++){
            String s2 = words[n];
            for(char c : s2.toCharArray()) {
                if(visited[c-'a']==-1) visited[c-'a'] = 0; //!!!!!!!!!!!
            }
            if(n==0) continue;
            String s1 = words[n-1];
            
            for(int i = 0; i<s1.length() && i<s2.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    char ch1 = s1.charAt(i);
                    char ch2 = s2.charAt(i);
                    if(!adjList.get(ch1-'a').contains(ch2)){ // de-dupe
                        adjList.get(ch1-'a').add(ch2);
                    }
                    break;
                }
            }
        }
    }
    
    public String alienOrderBFS(String[] words) {
        List<Set<Character>> adjList = new ArrayList<Set<Character>>();
        int[] indegrees = new int[26];
        buildAdjList(words, adjList, indegrees);
        
        //int count = adjList.size();
        Queue<Integer> zeroIndegrees = new LinkedList<Integer>();
        for(int i = 0; i<26; i++){
            if(indegrees[i]==0){
                zeroIndegrees.offer(i);
            }
        }
        //Queue<Character> nextZero = new LinkedList<Character>();
        StringBuilder res = new StringBuilder();
        while(!zeroIndegrees.isEmpty()){
            char ch = (char)('a' + zeroIndegrees.poll());
            res.append(ch);
            for(char next : adjList.get(ch-'a')){
                indegrees[next-'a']--;
                if(indegrees[next-'a']==0){
                    zeroIndegrees.offer(next-'a');
                }
            }
        }
        
        for(int i = 0; i<26; i++){
            if(indegrees[i]>0) return "";
        }
        return res.toString();
    }
    
    private void buildAdjList(String[] words, List<Set<Character>> adjList, int[] indegrees){
        for(int i = 0; i<26; i++){
            adjList.add(new HashSet<Character>());
        }
        Arrays.fill(indegrees, -1);///////////////
            
        for(int n = 0; n<words.length; n++){
            String s2 = words[n];
            for(char c : s2.toCharArray()) {
                if(indegrees[c-'a']==-1) indegrees[c-'a'] = 0; //!!!!!!!!!!!
            }
            if(n==0) continue;
            String s1 = words[n-1];
            
            for(int i = 0; i<s1.length() && i<s2.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    char ch1 = s1.charAt(i);
                    char ch2 = s2.charAt(i);
                    if(!adjList.get(ch1-'a').contains(ch2)){ // de-dupe
                        adjList.get(ch1-'a').add(ch2);
                        indegrees[ch2-'a']++;
                    }
                    break; //////////////////////
                }
            }
        }
    }
}

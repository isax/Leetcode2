public class Solution {
    
    // https://leetcode.com/discuss/64808/my-concise-java-solution-based-on-bfs-and-dfs
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();         
        Map<String, List<String>> nodeNeighbors = new HashMap<String, List<String>>(); // Neighbors for every node
        Map<String, Integer> distance = new HashMap<String, Integer>(); // Shortest distance of every node from the start node
        List<String> solution = new ArrayList<String>();

        wordList.add(endWord);          
        bfs(beginWord, endWord, wordList, nodeNeighbors, distance);                 
        dfs(beginWord, endWord, wordList, nodeNeighbors, distance, solution, res);   
        return res;
    }
    
    // BFS: Trace every node's distance from the start node (level by level).
   private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
         for (String str : dict) nodeNeighbors.put(str, new ArrayList<String>());

         Queue<String> queue = new LinkedList<String>();
         queue.offer(start);
         distance.put(start, 0);

         int level = 0;
         while (!queue.isEmpty()) {
              int count = queue.size();
              boolean foundEnd = false;
              for (int i = 0; i < count; i++) {
                  String cur = queue.poll();
                  //int curDistance = distance.get(cur);                
                  List<String> neighbors = getNeighbors(cur, dict);
                  
                  for (String neighbor : neighbors) {
                      nodeNeighbors.get(cur).add(neighbor);
                      if (!distance.containsKey(neighbor)) {// Check if visited
                          distance.put(neighbor, level + 1);
                          if (end.equals(neighbor))// Found the shortest path
                             foundEnd = true;
                          else
                             queue.offer(neighbor);
                      }
                  }
              }
              if (foundEnd) break; // found shortest distance, exit current level
              level++;
        }
   }
   
     // Find all next level nodes.    
private List<String> getNeighbors(String node, Set<String> dict) {
  List<String> res = new ArrayList<String>();
  char []chs = node.toCharArray();

  for (char ch ='a'; ch <= 'z'; ch++) {
      for (int i = 0; i < chs.length; i++) {
          if (chs[i] == ch) continue;
          char old_ch = chs[i];
          chs[i] = ch;
          if (dict.contains(new String(chs))) {
              res.add(new String(chs));
          }
          chs[i] = old_ch;
      }

  }
  return res;
}
  
    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) 
   {
       if (end.equals(cur)) {
           solution.add(cur);
           res.add(new ArrayList<String>(solution));
           solution.remove(solution.size() - 1);
       }else {
           for (String next : nodeNeighbors.get(cur)) {            
               if (distance.get(next) == distance.get(cur) + 1) {
                   solution.add(cur);
                   dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                   solution.remove(solution.size() - 1);
               }
            }
       }           
   }
  
  
}

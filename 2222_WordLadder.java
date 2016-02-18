public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/23029973
    // O(dict.size * 26*wordLength) both time and space
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        Set<String> visited = new HashSet<String>();
        
        int level = 1;
        while(!q.isEmpty()){
            int count = q.size();
            
            for(int i = 0; i<count; i++){
                String str = q.poll();
                if(str.equals(endWord)) return level;
                
                for(int j = 0; j<str.length(); j++){
                    char[] w = str.toCharArray(); /// PUT IT HERE TO RESET CHAR ARRAY FOR EACH J
                    //char old = w[j];
                    for(char c='a'; c<='z'; c++){
                        //if(old==c) continue;
                        w[j] = c;
                        String oneEdit = new String(w);
                        if(!visited.contains(oneEdit) && wordList.contains(oneEdit)){
                            q.offer(oneEdit);
                            visited.add(oneEdit);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

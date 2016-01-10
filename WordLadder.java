public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/23029973
    // O(dict.size * 26*wordLength) both time and space
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        
        Set<String> visited = new HashSet<String>(); 
        
        int last = 1;
        int cur = 0;
        int level = 1;
        
        while(!q.isEmpty()){
            String word = q.poll();
            last--;
            
            for(int i = 0; i<word.length(); i++){
                char[] w = word.toCharArray();
                
                for(char ch = 'a'; ch<='z'; ch++){
                    w[i] = ch;
                    String temp = new String(w);
                    if(temp.equals(endWord)){
                        return level+1;
                    }
                    
                    if(wordList.contains(temp) && !visited.contains(temp)){
                        q.offer(temp);
                        visited.add(temp);
                        cur++;
                    }
                }
            }
            if(last==0){
                level++;
                last = cur;
                cur = 0;
            }
        }
        return 0;
    }
}

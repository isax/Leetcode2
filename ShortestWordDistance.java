public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p = -1, q = -1;
        int local = words.length;
        
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(word1)) p = i;
            if(words[i].equals(word2)) q = i;
            
            if(p!=-1 && q!=-1){
                local = Math.min(local, Math.abs(p-q));
            }
        }
        return local;
    }
}

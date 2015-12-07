public class Solution {
    // https://leetcode.com/discuss/50715/12-16-lines-java-c
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p = -1, q = -1;
        int shortest = words.length;
        
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(word1)){
                p = i;
            } 
            
            if(words[i].equals(word2)){
                if(word1.equals(word2)){
                    p = q;
                }
                q = i;
            }
            
            if(p!=-1 && q!=-1){
                shortest = Math.min(shortest, Math.abs(p-q));
            }
        }
        return shortest;
    }
    
    public int shortestWordDistanceMine(String[] words, String word1, String word2) {
        int p = -1, q = -1;
        int shortest = words.length;
        
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2) && p!=-1){
                    shortest = Math.min(shortest, Math.abs(i-p));
                }
                p = i;
            } else if(words[i].equals(word2)){
                q = i;
            }
            
            if(p!=-1 && q!=-1){
                shortest = Math.min(shortest, Math.abs(p-q));
            }
        }
        return shortest;
    }
}

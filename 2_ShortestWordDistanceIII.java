public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int shortest = words.length;
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2)){
                    p2 = p1;
                }
                p1 = i;
            }else if(words[i].equals(word2)){
                p2 = i;
            }
            
            if(p1!=-1 && p2!=-1){
                shortest = Math.min(shortest, Math.abs(p1-p2));
            }
        }
        return shortest;
    }
}

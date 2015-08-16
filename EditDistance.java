public class Solution {
    // Good thought from Code Ganker http://blog.csdn.net/linhuanmars/article/details/24213795 
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int [][] cache = new int[len1+1][len2+1];
        
        for(int i = 0; i<len1+1; i++){
            cache[i][0] = i;
        }
        
        for(int j = 0; j<len2+1; j++){
            cache[0][j] = j;
        }
        
        for(int i = 1; i<len1+1; i++){
            for(int j = 1; j<len2+1; j++){
                int c1 = cache[i-1][j-1] + ((word1.charAt(i-1)==word2.charAt(j-1))?0:1);
                int c2 = cache[i-1][j] + 1;
                int c3 = cache[i][j-1] + 1;
                
                cache[i][j] = Math.min(c1, Math.min(c2, c3));
            }
        }
        return cache[len1][len2];
    }
}

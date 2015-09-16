public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int [][] dp = new int[len2+1][len1+1];
        
        for(int i = 0; i<=len1; i++){
            dp[0][i] = i;
        }
        
        for(int i = 0; i<=len2; i++){
            dp[i][0] = i;
        }
        
        for(int i = 1; i<=len2; i++){
            for(int j = 1; j<=len1; j++){
                int replace = word2.charAt(i-1)==word1.charAt(j-1)? dp[i-1][j-1]: dp[i-1][j-1]+1;
                int delete = dp[i][j-1] + 1;
                int insert = dp[i-1][j] + 1;
                
                dp[i][j] = Math.min(replace, Math.min(delete, insert));
            }
        }
        
        return dp[len2][len1];
    }
}

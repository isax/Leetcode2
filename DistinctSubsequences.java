public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/23589057
    // https://leetcode.com/discuss/48208/lines-solutions-with-detailed-explanations-time-and-space
    public int numDistinct(String s, String t) {
        if(s.length()<t.length()) return 0;
        
        int [][] dp = new int[t.length()+1][s.length()+1];
        
        for(int i = 0; i<s.length(); i++){
            dp[0][i] = 1;
        }
        
        for(int i = 1; i<=t.length(); i++){
            for(int j = 1; j<=s.length(); j++){
                if(t.charAt(i-1)!=s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}

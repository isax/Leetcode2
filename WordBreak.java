public class Solution {
    // DP - Time: O(n^2) Space: O(n)
    public boolean wordBreak(String s, Set<String> wordDict) {
        // dp means [0, i) is breakable
        boolean[]dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int i = 1; i<=s.length(); i++){
            String subStr = s.substring(0,i);
            
            for(int k = 0; k<=i-1; k++){
                if(dp[k] && wordDict.contains(s.substring(k,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
} 

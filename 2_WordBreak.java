public class Solution {
    
    // dp...
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean [] dp = new boolean[len+1];
        dp[0] = true;
        
        for(int i = 1; i<=len; i++){
            for(int k = 0; k<i; k++){
                if(dp[k] && wordDict.contains(s.substring(k, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
    
    // My new....dfs + cache
    public boolean wordBreakDFS(String s, Set<String> wordDict) {
        int[][] cache = new int[s.length()][s.length()];
        for(int i = 0; i<cache.length; i++){
            Arrays.fill(cache[i], -1);
        }
        return helper(s, wordDict, 0, s.length()-1, cache);
    }
    
    private boolean helper(String s, Set<String> wordDict, int i, int j, int [][] cache){
        int len = s.length();
        if(i>j) return true;
        if(cache[i][j]!=-1) return cache[i][j]==1;
        
        for(int n = i; n<=j; n++){
            String str = s.substring(i, n+1);
            if(wordDict.contains(str)){
                if(helper(s, wordDict, n+1, j, cache)){
                    cache[i][j] = 1;
                    return true;
                }
            }
        }
        cache[i][j] = 0;
        return false;
    }
    
}

public class Solution {
    // https://leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
    // Greedy?
    
    // https://leetcode.com/discuss/43966/accepted-c-dp-solution-with-a-trick
    public boolean isMatch(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        
        for(int j = 1; j<=l2; j++){
            dp[0][j] = dp[0][j-1] && p.charAt(j-1)=='*';
            if(!dp[0][j]) break;
        }
        
        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                char curP = p.charAt(j-1);
                
                if(curP=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else{
                    // number or ?
                    dp[i][j] = dp[i-1][j-1] && (curP=='?' || curP==s.charAt(i-1));
                }
            }
        }
        return dp[l1][l2];
    }
}

public class Solution {
    // https://leetcode.com/discuss/43860/9-lines-16ms-c-dp-solutions-with-explanations
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();
        
        boolean [][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        
        // dp[i][0]==false when i!=0 so we only need to start from j=1
        // dp[0][i] we should process them because "" vs 'a*, the latter can be a0 == ""
        
        // Some explanations: https://leetcode.com/discuss/55253/my-dp-approach-in-python-with-comments-and-unittest
        /*
        # Update the corner case of when s is an empty string but p is not.
        # Since each '*' can eliminate the charter before it, the table is
        # vertically updated by the one before previous. [test_symbol_0]
        for i in range(2, len(p) + 1):
            table[i][0] = table[i - 2][0] and p[i - 1] == '*'
        */
        
        for(int i = 0; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                char curP = p.charAt(j-1);
                
                if(curP=='*'){
                    dp[i][j] = (j>1 && dp[i][j-2]) // *==0
                       ||      // dp[i][j-1] //*==1
                       i>0 && dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'); // *>1
                }else{
                    // number or .
                    dp[i][j] = i>0 && dp[i-1][j-1] && (curP=='.' || curP==s.charAt(i-1));
                }
            }
        }
        return dp[l1][l2];
    }
}

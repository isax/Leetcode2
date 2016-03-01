public class Solution {
    
    public boolean isMatch233(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        
        boolean [][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        
        for(int i = 0; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                char chp = p.charAt(j-1);
                
                if(chp != '*'){
                    dp[i][j] = i>=1 && (chp=='.' || s.charAt(i-1)==chp) && dp[i-1][j-1]; 
                } else{
                    dp[i][j] = j>=2 && dp[i][j-2] // match empty
                               || i>=1 && j>=2 && (p.charAt(j-2)=='.' || s.charAt(i-1)==p.charAt(j-2)) && dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }
    
    public boolean isMatchLatest(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        
        boolean[][]dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for(int j = 2; j<=l2; j++){
            dp[0][j] = dp[0][j-2] && p.charAt(j-1)=='*'; // corner case
        }
        
        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                char c1 = s.charAt(i-1);
                char c2 = p.charAt(j-1);
                
                if(c2!='*'){
                    dp[i][j] = dp[i-1][j-1] && (c1==c2 || c2=='.');
                }else{
                    dp[i][j] = dp[i][j-2] // match zero
                    || (dp[i-1][j] && (c1==p.charAt(j-2)||p.charAt(j-2)=='.')); // match > 0
                    // when matching == 1 time, == [i-1][j] matches 0 times
                    // forgot p.charAt(j-2)=='.'
                }
            }
        }
        return dp[l1][l2];
    }
    
    
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

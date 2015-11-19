public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        
        boolean [][][] dp = new boolean[len][len][len+1];
        
        for(int l = 1; l<=len; l++){
            for(int i = 0; i<=len-l; i++){
                for(int j = 0; j<=len-l; j++){
                    if(l==1){
                        dp[i][j][l] = s1.charAt(i)==s2.charAt(j);
                    }else{
                        for(int ll = 1; ll<l; ll++){
                            if(dp[i][j][ll] && dp[i+ll][j+ll][l-ll] 
                            || dp[i][j+l-ll][ll] && dp[i+ll][j][l-ll]){
                                dp[i][j][l] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}

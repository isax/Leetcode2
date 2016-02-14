public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/24506703
    // 因为长度小于n的所有情况我们都在前面求解过了（也就是长度是最外层循环）。
    public boolean isScramble(String s1, String s2) {
        // to calculate s1, s2
        // we need the isScramble of all their substrings
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len+1];
        
        for(int l = 1; l<=len; l++){
            //for(int i = 0; i<len; i++){ ////////////////////// WRONG
            for(int i = 0; i<=len-l; i++){
                for(int j = 0; j<=len-l; j++){
                    if(l==1){
                        dp[i][j][1] = s1.charAt(i)==s2.charAt(j);
                    }else{
                        for(int cut = 1; cut<l; cut++){
                            if(dp[i][j][cut] && dp[i+cut][j+cut][l-cut] || dp[i][j+l-cut][cut] && dp[i+cut][j][l-cut]){
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

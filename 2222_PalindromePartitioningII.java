public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] isPal = new boolean[len][len];
        
        for(int i = 0; i<len; i++){
            int minCut = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=1 || isPal[j+1][i-1])){
                    isPal[j][i] = true;
                    minCut = j==0?0:Math.min(minCut, dp[j-1] + 1);
                }
            }
            dp[i] = minCut;
        } 
        return dp[len-1];
    }
    
    public int minCutMine(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        boolean[][] isPal = new boolean[len][len];
        
        for(int k = 1; k<=len; k++){ // k is the length sub problem
            for(int i = 0; i<len+1-k; i++){
                int j = i + k - 1;
                int minCut = Integer.MAX_VALUE;
                for(int cut = i; cut <= j; cut++){
                    if( cut==j || s.charAt(cut)==s.charAt(j) && (j-cut<=1 || isPal[cut+1][j-1])){
                        isPal[cut][j] = true;
                        minCut = Math.min(minCut, cut==i?0:(dp[i][cut-1] + 1));
                    }
                }
                dp[i][j] = minCut;
            }
        } 
        return dp[0][len-1];
    }
}

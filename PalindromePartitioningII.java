public class Solution {
    // https://leetcode.com/discuss/76411/easiest-java-dp-solution-97-36%25
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] isPal = new boolean[len][len];
        
        for(int i = 0; i<len; i++){
            int local = i;
            for(int j = 0; j<=i; j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<2 || isPal[j+1][i-1])){ // i to j is palindrome
                    isPal[j][i] = true; 
                    local = j==0?0:Math.min(local, dp[j-1]+1);
                }
            }
            dp[i] = local;
        }
        return dp[len-1];
    }
}

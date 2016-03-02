public class Solution {
    
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int [][] dp = new int[row][col]; // life needed before entering i,j
        
        for(int i = row-1; i>=0; i--){
            for(int j = col-1; j>=0; j--){
                if(i==row-1 && j==col-1){
                    dp[i][j] = Math.max(1, 1-dungeon[i][j]);
                }else{
                    dp[i][j] = Math.min((i+1<=row-1?dp[i+1][j]:Integer.MAX_VALUE), (j+1<=col-1?dp[i][j+1]:Integer.MAX_VALUE)) - dungeon[i][j];
                    dp[i][j] = Math.max(1, dp[i][j]);
                }
            }
        }
        return dp[0][0];
    }
    
    // https://leetcode.com/discuss/47153/6-lines-16-ms-c-o-mn-time-o-n-space
    // https://leetcode.com/discuss/20721/my-ac-java-version-suggestions-are-welcome
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        // dp[i][j] is the amount needed before enter i,j
        int[][]dp = new int[row][col];
        
        dp[row-1][col-1] = Math.max(1-dungeon[row-1][col-1], 1);
        for(int i = col-2; i>=0; i--){
            dp[row-1][i] = Math.max(1, dp[row-1][i+1]-dungeon[row-1][i]);
        }
        
        for(int i = row-2; i>=0; i--){
            dp[i][col-1] = Math.max(1, dp[i+1][col-1]-dungeon[i][col-1]);
        }
        
        for(int i = row-2; i>=0; i--){
            for(int j = col-2; j>=0; j--){
                int down = Math.max(1, dp[i+1][j]-dungeon[i][j]);
                int right = Math.max(1, dp[i][j+1]-dungeon[i][j]);
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
}

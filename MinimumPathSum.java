public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int [][] dp = new int[row][col];
        
        dp[0][0] = grid[0][0];
        for(int i = 1; i<col; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        
        for(int i = 1; i<row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        for(int i=1; i<row; i++){
            for(int j = 1; j<col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
    
    // optimized space
    // idea: https://leetcode.com/discuss/38360/10-lines-28ms-o-n-space-dp-solution-in-c-with-explanations
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[]pre = new int[col];
        int[]cur = new int[col];
        
        pre[0] = grid[0][0];
        for(int i = 1; i<col; i++){
            pre[i] = pre[i-1] + grid[0][i];
        }
        
        for(int i=1; i<row; i++){
            cur[0] = pre[0] + grid[i][0];
            for(int j = 1; j<col; j++){
                cur[j] = Math.min(pre[j], cur[j-1]) + grid[i][j];
            }
            pre = Arrays.copyOf(cur, cur.length); // switch cur to pre, get ready for next iteration of row
        }
        return pre[col-1];
    }
}

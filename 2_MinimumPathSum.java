public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[]dp =new int[col];
        dp[0] = grid[0][0];
        
        for(int i = 1; i<col; i++){
            dp[i] = dp[i-1] + grid[0][i];
        }
       
        for(int i = 1; i<row; i++){
            for(int j = 0; j<col; j++){
                if(j==0) dp[j] += grid[i][j]; 
                else dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
            }
        }
        return dp[col-1];
    }
    
    public int minPathSumMine(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[]dp =new int[col];
       
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                int minPathBefore = 0;
                
                if(i==0 && j==0) minPathBefore = 0;
                else if(i==0) minPathBefore = dp[j-1];
                else if(j==0) minPathBefore = dp[j];
                else minPathBefore = Math.min(dp[j], dp[j-1]);
                
                dp[j] = minPathBefore + grid[i][j];
                
            }
        }
        return dp[col-1];
    }
    
    
    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][]dp =new int[row][col];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i<row; i++){
            dp[i][0] += dp[i-1][0] + grid[i][0];
        }
        
        for(int i = 1; i<col; i++){
            dp[0][i] += dp[0][i-1] + grid[0][i];
        }
        
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}

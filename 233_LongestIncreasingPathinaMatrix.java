public class Solution {
    // 312
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int [][] dp = new int[row][col];
        int max = 1;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                //if(dp[i][j]!=0){
                max = Math.max(max, dfs(matrix, i, j, dp));
                //} 
            }
        }
        return max;
    }
    
    int [][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private int dfs(int[][] matrix, int i, int j, int[][]dp){
        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j] = 1;
        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x<0 || y<0 || x>matrix.length-1 || y>matrix[0].length-1 || matrix[i][j]>=matrix[x][y]){
                continue;
            }
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(matrix, x, y, dp));
        }
        return dp[i][j];
    }

/////
    
    
    // https://leetcode.com/discuss/81389/15ms-concise-java-solution
    // should be fine even without visited 
    // since we do the check "matrix[i][j]<matrix[i-1][j]", and the visiting should be only increasing.
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] cache = new int[row][col];
        
        for(int i = 0; i<row; i++){
            Arrays.fill(cache[i], -1);
        }
        
        //boolean[][] visited = new boolean[row][col];
        int max = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                max = Math.max(max, dfs(cache, matrix, i, j));
            }
        }
        return max;
    }
    
    
    // no count in the argument needed... the next recursive doesn't need the count from parent
    private int dfs(int[][] cache, int[][] matrix, int i, int j){
        if(cache[i][j]!=-1) return cache[i][j];
        //if(visited[i][j]) return 0;
        
        //visited[i][j] = true; // on the fly
        int max = 1;
        if(i>0 && matrix[i][j]<matrix[i-1][j]){
            max = Math.max(1+dfs(cache, matrix, i-1, j), max);
        }
        
        if(j>0 && matrix[i][j]<matrix[i][j-1]){
            max = Math.max(1+dfs(cache, matrix, i, j-1), max);
        }
        
        if(i<matrix.length-1 && matrix[i][j]<matrix[i+1][j]){
            max = Math.max(1+dfs(cache, matrix, i+1, j), max);
        }
        
        if(j<matrix[0].length-1 && matrix[i][j]<matrix[i][j+1]){
            max = Math.max(1+dfs(cache, matrix, i, j+1), max);
        }
        //visited[i][j] = false;
        cache[i][j] = max;
        return max;
    }
    
    // no count in the argument needed... the next recursive doesn't need the count from parent
    private int dfs2(boolean[][] visited, int[][] cache, int[][] matrix, int i, int j){
        if(cache[i][j]!=-1) return cache[i][j];
        
        visited[i][j] = true; // on the fly
        int max = 1;
        if(i>0 && !visited[i-1][j] && matrix[i][j]<matrix[i-1][j]){
            max = Math.max(1+dfs2(visited, cache, matrix, i-1, j), max);
        }
        
        if(j>0 && !visited[i][j-1] && matrix[i][j]<matrix[i][j-1]){
            max = Math.max(1+dfs2(visited, cache, matrix, i, j-1), max);
        }
        
        if(i<matrix.length-1 && !visited[i+1][j] && matrix[i][j]<matrix[i+1][j]){
            max = Math.max(1+dfs2(visited, cache, matrix, i+1, j), max);
        }
        
        if(j<matrix[0].length-1 && !visited[i][j+1] && matrix[i][j]<matrix[i][j+1]){
            max = Math.max(1+dfs2(visited, cache, matrix, i, j+1), max);
        }
        visited[i][j] = false;
        cache[i][j] = max;
        return max;
    }
}

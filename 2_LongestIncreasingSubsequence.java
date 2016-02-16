public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] visited = new int[row][col];
        for(int i = 0; i<row; i++){
            Arrays.fill(visited[i], -1);
        }
        int max = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(visited[i][j]==-1) max = Math.max(max, dfs(i, j, matrix, visited));
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] visited){
        if(visited[i][j]!=-1) return visited[i][j];
        
        //visited[i][j] = 0; 
        //since we do the check "matrix[i][j]<matrix[i-1][j]", and the visiting should be only increasing.
        int max = 1;
        if(i>0 && matrix[i][j]<matrix[i-1][j]) {
            max = Math.max(1+dfs(i-1, j, matrix, visited), max);
        }
        if(j>0 && matrix[i][j]<matrix[i][j-1]) {
            max = Math.max(1+dfs(i, j-1, matrix, visited), max);
        }
        if(i<matrix.length-1 && matrix[i][j]<matrix[i+1][j]) {
            max = Math.max(1+dfs(i+1, j, matrix, visited), max);
        }
        if(j<matrix[0].length-1 && matrix[i][j]<matrix[i][j+1]) {
            max = Math.max(1+dfs(i, j+1, matrix, visited), max);
        }
        visited[i][j] = max;
        return max;
    }
}

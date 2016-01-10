public class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row==0) return 0;
        int col = matrix[0].length;
        int global = 0;
        
        int [][] cache = new int[row][col];
        for(int i = 0; i<col; i++){
            cache[0][i] = matrix[0][i] - '0';
            global = Math.max(global, cache[0][i]);
        }
        
	   	for (int i = 0; i < row; i++) {
	   	    cache[i][0] = matrix[i][0] - '0';
	   	    global = Math.max(global, cache[i][0]);
	   	}
        
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                cache[i][j] = matrix[i][j] == '0' ? 0 : Math.min(cache[i-1][j], Math.min(cache[i][j-1], cache[i-1][j-1])) + 1;
                global = Math.max(global, cache[i][j]);
            }
        }
        return global*global;
    }
}

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return;
        
        boolean firstRow = false;
        boolean firstCol = false;
        
        for(int i = 0; i<matrix[0].length; i++){
            if(matrix[0][i]==0) {
                firstRow = true;
                break;
            }
        }
        
        for(int i = 0; i<matrix.length; i++){
            if(matrix[i][0]==0) {
                firstCol = true;
                break;
            }
        }
        
        for(int row = 1; row<matrix.length; row++){
            for(int col = 1; col<matrix[0].length; col++){
                if(matrix[row][col]==0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        
        for(int row = 1; row<matrix.length; row++){
            for(int col = 1; col<matrix[0].length; col++){
                if(matrix[0][col]==0 || matrix[row][0]==0){
                    matrix[row][col] = 0;
                }
            }
        }
        
        if(firstRow){
            for(int i = 0; i<matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(firstCol){
            for(int i = 0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}

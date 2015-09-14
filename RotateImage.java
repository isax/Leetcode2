public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int numOfPasses = n/2;
        
        for(int p = 0; p<numOfPasses; p++){
            for(int i = p; i<n-p-1; i++){
                int temp = matrix[p][i];
                
                matrix[p][i] = matrix[n-1-i][p];
                matrix[n-1-i][p] = matrix[n-1-p][n-1-i];
                matrix[n-1-p][n-1-i] = matrix[i][n-1-p];
                matrix[i][n-1-p] = temp;
            }
        }
    }
}

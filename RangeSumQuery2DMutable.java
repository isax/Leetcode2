public class NumMatrix {
    // https://leetcode.com/discuss/71169/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
    // save for later

    // https://leetcode.com/discuss/70948/15ms-easy-to-understand-java-solution
    private int[][] colSums;
    private int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return;
        this.matrix = matrix;
        createColSums(matrix);
    }
    
    private void createColSums(int[][]matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        
        colSums = new int[row+1][col];
        for(int i = 1; i<=row; i++){
            for(int j = 0; j<col; j++){
                colSums[i][j] = colSums[i-1][j] + matrix[i-1][j];
            }
        }
    }

    public void update(int row, int col, int val) { // O(m)
        for(int i = row+1; i<colSums.length; i++){
            colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) { // O(n)
        int sum = 0;
        for(int i = col1; i<=col2; i++){
            sum += colSums[row2+1][i] - colSums[row1][i];
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);

public class NumMatrix {
    // https://leetcode.com/discuss/69424/clean-c-solution-and-explaination-o-mn-space-with-o-1-time
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return;
        sum = computeSum(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(sum==null) return 0;
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
    
    private int[][] computeSum(int[][]matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row+1][col+1];
        
        for(int i = 1; i<=row; i++){
            for(int j = 1; j<=col; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        return sum;
    }
    
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

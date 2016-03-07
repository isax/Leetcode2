public class Solution {
    // https://leetcode.com/discuss/14079/my-super-simple-solution-can-used-for-both-spiral-matrix-and
    public int[][] generateMatrix(int n) {
        int [][] results = new int[n][n];
        
        int i = 1;
        int rowBegin = 0, rowEnd = n-1;
        int colBegin = 0, colEnd = n-1;
        
        while(i<=n*n){
            // upper row
            for(int col = colBegin; col<=colEnd; col++){
                results[rowBegin][col] = i;
                i++;
            }
            rowBegin++;
            
            // right col
            for(int row = rowBegin; row<=rowEnd; row++){
                results[row][colEnd] = i;
                i++;
            }
            colEnd--;
            
            if(rowBegin<=rowEnd){
                // bottom row
                for(int col = colEnd; col>=colBegin; col--){
                    results[rowEnd][col] = i;
                    i++;
                }
                rowEnd--;
            }
            
            if(colBegin<=colEnd){
                // left col
                for(int row = rowEnd; row>=rowBegin; row--){
                    results[row][colBegin] = i;
                    i++;
                }
                colBegin++;
            }
        }
        return results;
    }
}

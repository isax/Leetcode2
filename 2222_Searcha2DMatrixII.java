public class Solution {
    // start from top right
    public boolean searchMatrixOn(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length-1;
        
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
       return search(matrix, target, 0, matrix.length-1, 0);
    }
    
    public boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int colStart) {
        if(rowStart>rowEnd || colStart==matrix[0].length) return false;
        
        int low = rowStart;
        int high = rowEnd;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(matrix[mid][colStart] == target){
                return true;
            }else if(matrix[mid][colStart]<target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return search(matrix, target, rowStart, high, colStart+1) ;
    }
}

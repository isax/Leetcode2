public class Solution {
    // O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        
        while(row<matrix.length && col>=0){
            if(matrix[row][col]>target){
                col--;
            }else if(matrix[row][col]<target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
    
    
    // Mine: O(nlogm)
    public boolean searchMatrixMine(int[][] matrix, int target) {
       return search(matrix, target, 0, matrix.length-1, 0);
    }
    
    private boolean search(int[][]matrix, int target, int low, int high, int colStart){
        if(colStart==matrix[0].length) return false;
        
         // search for which col
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
        
        if(high<0) return false;
        
        return search(matrix, target, 0, high, colStart+1);
        
    }
}

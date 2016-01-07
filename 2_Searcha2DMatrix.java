public class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0 || matrix[0].length==0) return false;
        
        return search(matrix, target, 0, matrix.length*matrix[0].length-1);
    }
    
    public boolean search(int[][]matrix, int target, int left, int right){
        if(left>right) return false;
        
        int mid = (left+right)/2;
        int row = mid/matrix[0].length;
        int col = mid%matrix[0].length;
        
        if(matrix[row][col]==target) {
            return true;
        }else if(matrix[row][col]<target){
            return search(matrix, target, mid+1, right);
        }else{
            return search(matrix, target, left, mid-1);
        }
        
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row==0||col==0) return false;
        
        int left = 0, right = row-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target) left = mid+1;
            else right = mid-1;
        }
        int theRow = right;
        if(theRow==-1) return false;
        
        left = 0; right = col-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(matrix[theRow][mid]==target) return true;
            else if(matrix[theRow][mid]<target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
    
    
}

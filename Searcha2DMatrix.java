public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        
        return search(matrix, target, 0, matrix.length*matrix[0].length-1);
    }
    
    public boolean search(int[][]matrix, int target, int left, int right){
        if(left>right) return false;
        
        int mid = (left+right)/2;
        int n = matrix[0].length;
        
        int i = mid/n;
        int j = mid%n;
        
        if(matrix[i][j]==target){
            return true; 
        }else if(matrix[i][j]<target){
            return search(matrix, target, mid+1, right);
        }else{
            return search(matrix, target, left, mid-1);
        }
    }
}

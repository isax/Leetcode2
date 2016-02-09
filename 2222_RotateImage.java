public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return;
        
        int n = matrix.length;
        int left = 0, right = n-2;
        for(int level = 0; level<n/2; level++){
            for(int i = left; i<=right; i++){
                int temp = matrix[level][i];
                matrix[level][i] = matrix[n-1-i][level];
                matrix[n-1-i][level] = matrix[n-1-level][n-1-i];
                matrix[n-1-level][n-1-i] = matrix[i][n-1-level];
                matrix[i][n-1-level] = temp;
            }
            left++;
            right--;
        }
    }
}

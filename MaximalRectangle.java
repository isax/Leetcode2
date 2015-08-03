public class Solution {
    // Reference: https://leetcodenotes.wordpress.com/2013/10/19/leetcode-maximal-rectangle-0101%E7%BB%84%E6%88%90%E7%9A%84%E7%9F%A9%E9%98%B5%EF%BC%8C%E6%B1%82%E9%87%8C%E9%9D%A2%E5%85%A8%E6%98%AF1%E7%9A%84%E7%9F%A9%E5%BD%A2%E7%9A%84%E6%9C%80%E5%A4%A7%E9%9D%A2/
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        
        int[][] processedMatrix = preprocess(matrix);
        int global = Integer.MIN_VALUE;
        
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                int cur_width = processedMatrix[row][col];
                int height = 1;
                for(int i = row-1; i >=0; i--){ // go up
                    if(processedMatrix[i][col]>= cur_width){
                        height++;
                    }else{
                        break;
                    }
                }
                for(int j = row+1; j <matrix.length; j++){ // go down
                    if(processedMatrix[j][col]>= cur_width){
                        height++;
                    }else{
                        break;
                    }
                }
                int cur_area = cur_width*height;
                global = Math.max (cur_area, global);
            }
        }
        return global;
    }
    
    private int[][] preprocess(char[][]matrix){
        int[][] res = new int[matrix.length][matrix[0].length];
        
        for(int row = 0; row<matrix.length; row++){
            res[row][0] = matrix[row][0] - '0';
            for(int col = 1; col<matrix[0].length; col++){
                if(matrix[row][col]=='0'){
                    res[row][col]=0;
                }else{
                    res[row][col] = res[row][col-1] + 1;
                }
            }
        }
        return res;
    }
}

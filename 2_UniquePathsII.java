public class Solution {
    public int uniquePathsWithObstaclesMine(int[][] obstacleGrid) {
        if(obstacleGrid.length==0) return 0;
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[] curRow = new int[col];
        curRow[0] = obstacleGrid[0][0]==0?1:0;
        
        for(int i = 1; i<col; i++){ // first row
            curRow[i] = curRow[i-1]!=0 && obstacleGrid[0][i]!=1 ? 1:0;
        }
        
        for(int i = 1; i<row; i++){
            for(int j = 0; j<col; j++){
                if(obstacleGrid[i][j]==1){
                   curRow[j] = 0; 
                }else{
                     if(j!=0) {
                         curRow[j] = curRow[j] + curRow[j-1];
                     }
                }
             }
        }
        return curRow[col-1];
    }
    
    // http://blog.csdn.net/linhuanmars/article/details/22135231
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0) return 0;
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[] curRow = new int[col];
        curRow[0] = obstacleGrid[0][0]==0?1:0;
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(obstacleGrid[i][j]==1){
                   curRow[j] = 0; 
                }else{
                     if(j!=0) {
                         curRow[j] += curRow[j-1];
                     }
                }
             }
        }
        return curRow[col-1];
    }
}

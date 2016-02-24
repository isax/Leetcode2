public class Solution {
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        int[][] count = new int[row][col];
        
        int building = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1){
                    building++;
                }
            }
        }
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1){
                    Queue<Integer> r = new LinkedList<Integer>();
                    Queue<Integer> c = new LinkedList<Integer>();
                    boolean[][] visited = new boolean[row][col];
                    
                    r.offer(i); 
                    c.offer(j);
                    visited[i][j] = true;
                    int level = 0;
                    
                    while(!r.isEmpty()){
                        int size = r.size();
                        
                        for(int n = 0; n<size; n++){
                            int curR = r.poll();
                            int curC = c.poll();
                            count[curR][curC]++;
                            res[curR][curC] += level;
                            
                            if(curR>0 && !visited[curR-1][curC] && grid[curR-1][curC]==0){
                                //res[curR-1][curC] += level;
                                r.offer(curR-1);
                                c.offer(curC);
                                visited[curR-1][curC] = true;
                                
                            }
                            if(curC>0 && !visited[curR][curC-1] && grid[curR][curC-1]==0){
                                r.offer(curR);
                                c.offer(curC-1);
                                visited[curR][curC-1] = true;
                            }
                            if(curR<row-1 && !visited[curR+1][curC] && grid[curR+1][curC]==0){
                                r.offer(curR+1);
                                c.offer(curC);
                                visited[curR+1][curC] = true;
                            }
                            if(curC<col-1 && !visited[curR][curC+1] && grid[curR][curC+1]==0){
                                r.offer(curR);
                                c.offer(curC+1);
                                visited[curR][curC+1] = true;
                            }
                        }
                        level++;
                    }
                    
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==0 && count[i][j]==building) min = Math.min(min, res[i][j]);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}

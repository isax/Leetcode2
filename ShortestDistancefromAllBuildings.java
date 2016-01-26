public class Solution {
    
    // https://leetcode.com/discuss/74380/my-bfs-java-solution
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int[][] distance = new int[row][col];
        int[][] visitNum = new int[row][col];
        
        int count1 = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1){
                    count1++;
                    bfs(grid, i, j, distance, visitNum);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i =0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==0 && visitNum[i][j]==count1){
                    min = Math.min(distance[i][j], min);
                }
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    
    private void bfs(int[][] grid, int i, int j, int[][] distance, int[][]visitNum){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int n = 0; n<size; n++){
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                
                distance[x][y] += level;
                visitNum[x][y] ++;
                            
                if (x > 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                    queue.offer(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x + 1 < row && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                    queue.offer(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y > 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                    queue.offer(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y + 1 < col && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                    queue.offer(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
            }
            level++;
        }
    }
}

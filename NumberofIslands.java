public class Solution {
    
    // What about union find? https://leetcode.com/discuss/52833/8ms-c-solution-using-union-find-with-a-dummy-point
    
    // https://leetcode.com/discuss/48889/clear-%26-easy-java-solution
    public int numIslandsDFSOpt(char[][] grid) {
        if(grid.length==0) return 0;
        int width = grid.length;
        int len = grid[0].length;
        
        int count = 0;
        
        for(int i = 0; i<width; i++){
            for(int j = 0; j<len; j++){
                if(grid[i][j]=='1'){
                   dfsOpt(i, j, grid); 
                   count++;
                }
            }
        }
        return count;
    }
    
    private void dfsOpt(int i, int j, char[][]grid){
        if(i==grid.length || i==-1 || j==-1 || j==grid[0].length) return;
        if(grid[i][j]=='0') return; // dont forget...
        
        grid[i][j] = '0';
        dfsOpt(i+1, j, grid);
        dfsOpt(i-1, j, grid);
        dfsOpt(i, j+1, grid);
        dfsOpt(i, j-1, grid);
    }
    
    public int numIslandsMyDFS(char[][] grid) {
        if(grid.length==0) return 0;
        int width = grid.length;
        int len = grid[0].length;
        
        boolean [][] visited = new boolean[width][len];
        int count = 0;
        
        for(int i = 0; i<width; i++){
            for(int j = 0; j<len; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int i, int j, char[][]grid, boolean[][] visited){
        int width = grid.length;
        int len = grid[0].length;
        
        if(visited[i][j] || grid[i][j]=='0'){
            return;
        }
        visited[i][j] = true;
        
        if(i!=0){
            dfs(i-1, j, grid, visited);
        }
        if(j!=0){
            dfs(i, j-1, grid, visited);
        }
        if(i!=width-1){
            dfs(i+1, j, grid, visited);
        }
        if(j!=len-1){
            dfs(i, j+1, grid, visited);
        }
    }
    
    // Can also check this BFS https://leetcode.com/discuss/41053/java-dfs-and-bfs-solution
    public int numIslandsMyBFS(char[][] grid) {
       if(grid.length==0) return 0;
       
       int width = grid.length;
       int len = grid[0].length;
       
       boolean [][] visited = new boolean[width][len];
       
       int count = 0;
       
       for(int i = 0; i<width; i++){
           for(int j = 0; j<len; j++){
               if(visited[i][j] || grid[i][j]=='0') continue;
               
               // bfs
               Queue<Integer> queueRow = new LinkedList<Integer>();
               Queue<Integer> queueCol = new LinkedList<Integer>();
               
               queueRow.offer(i);
               queueCol.offer(j);
               
               while(!queueRow.isEmpty()){
                   int row = queueRow.poll();
                   int col = queueCol.poll();
                   
                   if(!visited[row][col] && grid[row][col]=='1'){ // if no checking visted, dead loop for [1,1]
                       visited[row][col] = true;
                       
                       if(col!=len-1) {
                           queueRow.offer(row);
                           queueCol.offer(col+1);
                       }
                       if(col!=0){ // have to dive left-wards as well
                           queueRow.offer(row);
                           queueCol.offer(col-1);
                       }
                       if(row!=width-1){ 
                           queueRow.offer(row+1);
                           queueCol.offer(col);
                       }
                       if(row!=0){ // have to dive upwards as well
                           queueRow.offer(row-1);
                           queueCol.offer(col);
                       }
                   }
               }
               count++; // current dive finishes, one more island
           }
       }
       return count;
    }
}

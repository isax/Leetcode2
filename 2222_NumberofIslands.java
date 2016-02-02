public class Solution {
    
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void bfs(char[][]grid, boolean[][]visited, int r, int c){
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(r*col+c);
        
        while(!q.isEmpty()){
            int cor = q.poll();
            
            int i = cor/col;
            int j = cor%col;
            
            if(j+1<col && grid[i][j+1]=='1' && !visited[i][j+1]){
                q.offer(i*col+j+1);
                visited[i][j+1] = true; // !!!!!!!!!!!!!!!! mark as early as possible otherwise enqueue duplicate
            }
            if(i-1>=0 && grid[i-1][j]=='1'&& !visited[i-1][j]){
                q.offer((i-1)*col+j);
                visited[i-1][j] = true;
            }
            if(j-1>=0 && grid[i][j-1]=='1'&& !visited[i][j-1]){
                q.offer(i*col+j-1);
                visited[i][j-1] = true;
            }
            if(i+1<row && grid[i+1][j]=='1'&& !visited[i+1][j]){
                q.offer((i+1)*col+j);
                visited[i+1][j] = true;
            }
            visited[i][j] = true;
        }
    }
    
    
    
    // https://leetcode.com/discuss/81837/java-easy-version-to-understand
    // https://leetcode.com/discuss/41753/12-ms-easy-c-solution-with-detailed-explanations
    
    public int numIslandsDFS2(char[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]=='1' && !visited[i][j]) {
                    dfs2(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs2(char[][]grid, boolean[][]visited, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        visited[i][j] = true;
        
        if(j+1<col && grid[i][j+1]=='1' && !visited[i][j+1]){
            dfs2(grid, visited, i, j+1);
        }
        
        if(i-1>=0 && grid[i-1][j]=='1'&& !visited[i-1][j]){
            dfs2(grid, visited, i-1, j);
        }
        
        if(j-1>=0 && grid[i][j-1]=='1'&& !visited[i][j-1]){
            dfs2(grid, visited, i, j-1);
        }
        
        if(i+1<row && grid[i+1][j]=='1'&& !visited[i+1][j]){
            dfs2(grid, visited, i+1, j);
        }
    }
    
    public int numIslandsDFS1(char[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]=='1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][]grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        
        grid[i][j] = '0'; // sink
        // should be put it here before dfs, like visited=true
        
        // Not like union, need to dfs 4 directions
        if(j+1<col && grid[i][j+1]=='1'){
            dfs(grid, i, j+1);
        }
        
        if(i-1>=0 && grid[i-1][j]=='1'){
            dfs(grid, i-1, j);
        }
        
        if(j-1>=0 && grid[i][j-1]=='1'){
            dfs(grid, i, j-1);
        }
        
        if(i+1<row && grid[i+1][j]=='1'){
            dfs(grid, i+1, j);
        }
    }
    
    // https://leetcode.com/discuss/79537/java-union-find-solution
    int count = 0;
    // Union find
    public int numIslandsUnionFind(char[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        
        int[] uf = new int[row*col];
        
        count = initUf(grid, uf);
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]=='0') continue;
                
                if(j+1<col && grid[i][j+1]=='1'){
                    union(i*col+j, i*col+j+1, uf);
                }
                
                if(i+1<row && grid[i+1][j]=='1'){
                    union(i*col+j, (i+1)*col+j, uf);
                }
            }
        }
        return count;
    }
    
    private void union(int i, int m, int[]uf){
        int r1 = findRoot(uf, i);
        int r2 = findRoot(uf, m);
        
        if(r1==r2) {
            return;
        }else{
            uf[r1] = r2;
            count--;
        }
    }
    
    private int findRoot(int[]uf, int i){
        while(uf[i]!=i){
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
    
    private int initUf(char[][] grid, int[]uf){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    count++;
                    uf[i*grid[0].length+j] = i*grid[0].length+j;
                }
            }
        }
        return count;
    }
}

public class Solution {
    // xor in https://leetcode.com/discuss/23165/accepted-very-short-java-solution-no-additional-space
    public boolean exist(char[][] board, String word) {
        if(board.length==0 || board[0].length==0 || word.length()==0) return false;
        int row = board.length;
        int col = board[0].length;
        
        boolean[][]visited = new boolean[row][col];
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                boolean cur = dfs2(board, i, j, visited, 0, word);
                if(cur) return true;
            }
        }
        return false;
    }
    
    private boolean dfs2(char[][]board, int i, int j, boolean[][]visited, int cur, String word){
        if(cur==word.length()) return true;
        if(i<0 || j<0 || i==board.length || j==board[0].length) return false;
        
        if(visited[i][j] || board[i][j]!=word.charAt(cur)){
            return false;
        }
        
        visited[i][j] = true;
        boolean res = dfs2(board, i+1, j, visited, cur+1, word) || dfs2(board, i, j+1, visited, cur+1, word)
        ||dfs2(board, i-1, j, visited, cur+1, word) || dfs2(board, i, j-1, visited, cur+1, word);
        visited[i][j] = false;
        return res;
    }
    
    // Mine
    public boolean existMine(char[][] board, String word) {
        if(board.length==0 || board[0].length==0 || word.length()==0) return false;
        int row = board.length;
        int col = board[0].length;
        
        boolean[][]visited = new boolean[row][col];
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(board[i][j]==word.charAt(0)){
                    visited[i][j] = true;
                    boolean cur = dfs(board, i, j, visited, 1, word);
                    if(cur) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][]board, int i, int j, boolean[][]visited, int cur, String word){
        if(cur==word.length()) return true;
        
        if(i!=0){
            if(!visited[i-1][j] && board[i-1][j]==word.charAt(cur)){
                visited[i-1][j] = true;
                if(dfs(board, i-1, j, visited, cur+1, word)) return true;
                visited[i-1][j] = false;
            }
        }
        
        if(i!=board.length-1){
            if(!visited[i+1][j] && board[i+1][j]==word.charAt(cur)){
                visited[i+1][j] = true;
                if(dfs(board, i+1, j, visited, cur+1, word)) return true;
                visited[i+1][j] = false;
            }
        }
        
        if(j!=0){
            if(!visited[i][j-1] && board[i][j-1]==word.charAt(cur)){
                visited[i][j-1] = true;
                if(dfs(board, i, j-1, visited, cur+1, word)) return true;
                visited[i][j-1] = false;
            }
        }
        
        if(j!=board[0].length-1){
            if(!visited[i][j+1] && board[i][j+1]==word.charAt(cur)){
                visited[i][j+1] = true;
                if(dfs(board, i, j+1, visited, cur+1, word)) return true;;
                visited[i][j+1] = false;
            }
        }
        return false;
    }
}

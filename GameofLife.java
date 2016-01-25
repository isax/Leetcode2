public class Solution {
    // Follow up: https://leetcode.com/discuss/62185/infinite-board-solution
    
    // https://leetcode.com/discuss/62038/c-ac-code-o-1-space-o-mn-time
    // 00, 01, 10, 11
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbors(board, i, j);
                
                if(board[i][j]==1){
                    if(count<2 || count>3){
                        board[i][j] = 1;
                    }else{
                        board[i][j] = 3;
                    }
                }else{
                    if(count==3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    // https://leetcode.com/discuss/67133/java-in-place-o-mn-solution
    public void gameOfLife2(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbors(board, i, j);
                // if dead, count nb == 3 make it live
                // if alive, count nb == 3 or nb==2 make it live
                // no need to care the next dead state, as the 2nd bit is default 0.
                if(count==3 || board[i][j] + count==3){
                    board[i][j] ^= 2;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int countNeighbors(int[][] board, int x, int y){
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int i = Math.max(0, x-1); i<=Math.min(m-1, x+1); i++){
            for(int j = Math.max(0, y-1); j<=Math.min(n-1, y+1); j++){
                if((board[i][j]&1)==1) count++;
            }
        }
        return count - (board[x][y]&1);
    }
}

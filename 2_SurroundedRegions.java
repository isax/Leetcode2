public class Solution {
    //dfs
    public void solve(char[][] board) {
        if(board.length==0 || board[0].length==0) return;
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i<col; i++){
            if(board[0][i]=='O') {
                dfs(board, 0, i);
            }
            if(board[row-1][i]=='O') {
                dfs(board, row-1, i);
            }
        }
        for(int i = 0; i<row; i++){
            if(board[i][0]=='O') {
                dfs(board, i, 0);
            }
            if(board[i][col-1]=='O') {
                dfs(board, i, col-1);
            }
        }
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    // https://leetcode.com/discuss/71862/very-strange-why-this-code-runtime-error-when-the-condition
    private void dfs(char[][]board, int i, int j){
        board[i][j] = '#';
        if(i>1 && board[i-1][j]=='O'){
            dfs(board, i-1, j);
        }
        if(j>1 && board[i][j-1]=='O'){
            dfs(board, i, j-1);
        }
        if(i<board.length-2 && board[i+1][j]=='O'){
            dfs(board, i+1, j);
        }
       
        if(j<board[0].length-2 && board[i][j+1]=='O'){
            dfs(board, i, j+1);
        }

    }
    // Fill colors (BFS): http://blog.csdn.net/linhuanmars/article/details/22904855
    private void fill2(char[][] board, int i, int j){
        if(board[i][j]!='O') return;
        
        int row = board.length;
        int col = board[0].length;
        
        Queue<Integer> bfsRow = new LinkedList<Integer>();
        Queue<Integer> bfsCol = new LinkedList<Integer>();
        
        if(board[i][j]=='O'){
            bfsRow.offer(i);
            bfsCol.offer(j);
            board[i][j] = '#';
        }
            
        while(!bfsRow.isEmpty()){ // all directions
            int r = bfsRow.poll();
            int c = bfsCol.poll();
                
            //board[r][c] = '#'; //NOTE: if comment out board[r-1][c]='#';  and uncomment this one, it will TLE. everytime we check neighbors and should mark it as # = visited. Otherwise, we will enqueue the same point to queue again and again. This would ensure we process each node once. Although it does not affect correctness.. it would be slow..
                
            if(r>0 && board[r-1][c] == 'O'){
                bfsRow.offer(r-1);
                bfsCol.offer(c);
                board[r-1][c]='#';  // CHECK NOTE ABOVE
            }
            if(c>0 && board[r][c-1] == 'O'){
                bfsRow.offer(r);
                bfsCol.offer(c-1);
                board[r][c-1]='#';
            }
            if(r<row-1 && board[r+1][c] == 'O'){
                bfsRow.offer(r+1);
                bfsCol.offer(c);
                board[r+1][c]='#';
            }
            if(c<col-1 && board[r][c+1] == 'O'){
                bfsRow.offer(r);
                bfsCol.offer(c+1);
                board[r][c+1]='#'; 
            }
        }
    }
}

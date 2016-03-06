public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    
    private boolean helper(char[][] board, int i, int j){
        if(j==board[0].length){
            if(i==board.length-1){
                return true;
            }
            i++;
            j = 0;
        }
        
        if(board[i][j]!='.'){
            return helper(board, i, j+1);
        }else{
            for(int n = 1; n<=9; n++){
                board[i][j] = (char)('0' + n);
                if(isValid(board, i, j) && helper(board, i, j+1)){
                    return true;
                }
            }
            board[i][j] = '.'; // reset
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j){
        Set<Character> set = new HashSet<Character>();
        for(int col = 0; col<board[0].length; col++){
            if(board[i][col]!='.' && !set.add(board[i][col])){
                return false;
            }
        }
        set.clear();
        for(int row = 0; row<board.length; row++){
            if(board[row][j]!='.' && !set.add(board[row][j])){
                return false;
            }
        }
        set.clear();
        int startX = i/3;///////////////////////
        int startY = j/3;
        for(int m = startX * 3; m < startX * 3 + 3; m++){
            for(int n = startY * 3; n < startY * 3 + 3; n++){
                if(board[m][n]!='.' && !set.add(board[m][n])){
                    return false;
                }
            }
        }
        return true;
    }
}

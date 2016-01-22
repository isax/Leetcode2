public class Solution {
    // https://leetcode.com/discuss/1045/is-a-naive-backtracking-approach-acceptable
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }
    
    private boolean solve(char[][]board, int n){
        if(n==81) return true;
        
        int row = n/9;
        int col = n%9;
        
        if(board[row][col]!='.'){
            return solve(board, n+1);
        }
        
        for(int i = 1; i<=9; i++){
            board[row][col] = (char)('1' + i - 1);
            if(isValidSudoku2(board, row, col)){
                if(solve(board, n+1)) return true; 
            }
            board[row][col] = '.';
        }
        return false;
    }
    
    private boolean isValidSudoku2(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<Character>();
        
        for(int j = 0; j<9; j++){
            if(!isValid(board[row][j])){
                continue;
            }
            if(!isNumeric(board[row][j]) || !set.add(board[row][j])) return false;
        }
        
        set.clear();
        
        for(int j = 0; j<9; j++){
            if(!isValid(board[j][col])){
                continue;
            }
            if(!isNumeric(board[j][col]) || !set.add(board[j][col])) return false;
        }
        
        set.clear();
        
        int i = row/3;
        int j = col/3;
        
        for(int m = i*3; m<i*3+3; m++){
            for(int n = j*3; n<j*3+3; n++){
                if(!isValid(board[m][n])){
                    continue;
                } 
                if(!isNumeric(board[m][n]) || !set.add(board[m][n])) return false;
            }
        }
        return true;
    }
    
    private boolean isValidSudoku(char[][] board) {
        int row = 9;
        int col = 9;
        
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i<row; i++){
            set.clear();
            for(int j = 0; j<col; j++){
                if(!isValid(board[i][j])){
                    continue;
                }
                if(!isNumeric(board[i][j]) || !set.add(board[i][j])) return false;
            }
        }
        
        for(int i = 0; i<col; i++){
            set.clear();
            for(int j = 0; j<row; j++){
                if(!isValid(board[j][i])){
                    continue;
                }
                if(!isNumeric(board[j][i]) || !set.add(board[j][i])) return false;
            }
        }
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                set.clear();
                
                for(int m = i*3; m<i*3+3; m++){
                    for(int n = j*3; n<j*3+3; n++){
                        if(!isValid(board[m][n])){
                            continue;
                        } 
                        if(!isNumeric(board[m][n]) || !set.add(board[m][n])) return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char ch){
        if(ch=='.') return false;
        else return true;
    }
    
    private boolean isNumeric(char ch){
        if(ch>='0'&& ch<='9') return true;
        else return false;
    }
}

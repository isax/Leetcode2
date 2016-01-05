public class Solution {
    public boolean isValidSudoku(char[][] board) {
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

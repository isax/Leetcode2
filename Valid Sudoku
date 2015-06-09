public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet <Character> hs = new HashSet<Character>();
        
        for(int i = 0; i<9; i++){
            hs.clear();
            for (int j = 0; j<9 ; j++){
                if(!validChar(board[i][j])){
                    continue;
                }
                
                if(!hs.add(board[i][j])) {
                    return false;
                }
            }
        }
        
        for(int j = 0; j<9; j++){
            hs.clear();
            for (int i = 0; i<9 ; i++){
                if(!validChar(board[i][j])){
                    continue;
                }
                
                if(!hs.add(board[i][j])) {
                    return false;
                }
            }
        }
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                hs.clear();
                for(int m = i*3; m<i*3+3; m++){
                    for(int n = j*3; n<j*3+3; n++){
                        if(!validChar(board[m][n])){
                            continue;
                        }
                         if(!hs.add(board[m][n])) {
                             return false;
                         }
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean validChar(char ch){
        if(ch=='.'){
            return false;
        }else{
            return true;
        }
    }
}
